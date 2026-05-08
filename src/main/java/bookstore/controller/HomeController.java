package bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import bookstore.model.Book;
import bookstore.repository.BookRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Controller
public class HomeController {

    @Autowired
    private BookRepository repo;

    @Autowired
private JavaMailSender mailSender;

    // Customer Homepage
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", repo.findAll());
        return "shop";
    }

    // Admin Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Admin Login Check
    @PostMapping("/admin-login")
    public String adminLogin(@RequestParam String username,
                             @RequestParam String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            return "redirect:/admin";
        }
        return "redirect:/login";
    }

    // Admin Panel
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("books", repo.findAll());
        return "admin";
    }

    // Add Book
    @PostMapping("/add")
    public String addBook(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam double price,
                          @RequestParam("file") MultipartFile file) throws IOException {

        String fileName = file.getOriginalFilename();

        Path path = Paths.get(
                System.getProperty("user.dir"),
                "src", "main", "resources", "static", "images",
                fileName
        );

        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        book.setImageUrl("/images/" + fileName);

        repo.save(book);
        return "redirect:/admin";
    }

    // Delete Book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/admin";
    }

    // Edit Book Page
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable int id, Model model) {
        model.addAttribute("book", repo.findById(id).orElse(null));
        return "edit";
    }

    // Update Book
    @PostMapping("/update")
    public String updateBook(Book book) {
        repo.save(book);
        return "redirect:/admin";
    }

    // Search Book (Admin)
    @GetMapping("/search")
    public String searchBook(@RequestParam String keyword, Model model) {
        model.addAttribute("books", repo.findByTitleContainingIgnoreCase(keyword));
        return "admin";
    }

    // Search Book (User)
    @GetMapping("/search-user")
public String searchUser(@RequestParam String keyword, Model model) {
    model.addAttribute("books", repo.findByTitleContainingIgnoreCase(keyword));
    model.addAttribute("keyword", keyword); // ← add this line
    return "shop";
}

    // Add one item to cart
    @GetMapping("/add-to-cart/{id}")
    @ResponseBody
    public String addToCart(@PathVariable int id, HttpSession session) {
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        Book book = repo.findById(id).orElse(null);
        if (book != null) cart.add(book);

        session.setAttribute("cart", cart);
        return "added";
    }

    // Remove one item from cart
    @GetMapping("/remove-from-cart/{id}")
    @ResponseBody
    public String removeFromCart(@PathVariable int id, HttpSession session) {
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart != null) {
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getId() == id) {
                    cart.remove(i);
                    break;
                }
            }
            session.setAttribute("cart", cart);
        }
        return "removed";
    }

    // Cart count = total items including duplicates
    @GetMapping("/cart-count")
    @ResponseBody
    public String cartCount(HttpSession session) {
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart == null) return "0";
        return String.valueOf(cart.size());
    }

    // Cart Page
    @GetMapping("/cart")
    public String cartPage(HttpSession session, Model model) {
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        double total = 0;
        for (Book b : cart) {
            total += b.getPrice();
        }

        model.addAttribute("cartItems", cart);
        model.addAttribute("total", total);
        return "cart";
    }

    // Remove Cart Item by index (used in cart page)
    @GetMapping("/remove-cart/{index}")
    public String removeCart(@PathVariable int index, HttpSession session) {
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart != null && index < cart.size()) {
            cart.remove(index);
        }
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    // Checkout Page
    // Checkout Page
@GetMapping("/checkout")
public String checkoutPage(HttpSession session, Model model) {
    List<Book> cart = (List<Book>) session.getAttribute("cart");
    if (cart == null) cart = new ArrayList<>();

    double total = 0;
    for (Book b : cart) {
        total += b.getPrice();
    }

    model.addAttribute("total", total);
    model.addAttribute("cartItems", cart);
    return "checkout";
}

    @PostMapping("/place-order")
public String placeOrder(@RequestParam String name,
                         @RequestParam String mobile,
                         @RequestParam String email,
                         @RequestParam String address,
                         HttpSession session,
                         Model model) {

    List<Book> cart =
        (List<Book>) session.getAttribute("cart");

    double total = 0;
    StringBuilder books = new StringBuilder();

    if(cart != null){
        for(Book b : cart){
            total += b.getPrice();
            books.append(b.getTitle())
                 .append(" - ₹")
                 .append(b.getPrice())
                 .append("\n");
        }
    }

    // Send Email
    SimpleMailMessage message =
            new SimpleMailMessage();

    message.setTo(email);
    message.setSubject("BookHaven Order Confirmed ✅");

    message.setText(
        "Hello " + name + ",\n\n" +

        "Your order has been placed successfully.\n\n" +

        "Ordered Books:\n" + books +

        "\nTotal Amount: ₹" + total +

        "\n\nDelivery Address:\n" + address +

        "\n\nMobile: " + mobile +

        "\n\nYour order will be delivered soon 📚🚚" +

        "\n\nThank you for shopping with BookHaven."
    );

    mailSender.send(message);

    session.removeAttribute("cart");

    model.addAttribute("name", name);

    return "success";
}

}