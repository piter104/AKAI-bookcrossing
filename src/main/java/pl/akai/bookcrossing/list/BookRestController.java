package pl.akai.bookcrossing.list;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookRestController {

    private final BookBean bookBean;
    private final OpinionBean opinionBean;

    @RequestMapping("/book/{id}/rent")
    @ResponseStatus(HttpStatus.OK)
    public void bookRental(@PathVariable(name = "id") Integer bookId) {
        bookBean.insertBookUserRequest(bookId);
    }

    @RequestMapping("/my-books/accept")
    @ResponseStatus(HttpStatus.OK)
    public void bookRentRequestAccept(@RequestParam(value = "id") Integer requestId) {
        bookBean.updateAvailable(requestId, false);
        bookBean.updateReader(requestId);
        bookBean.deleteBookRentRequestsById(requestId);
    }

    @RequestMapping("/my-books/decline")
    @ResponseStatus(HttpStatus.OK)
    public void bookRentRequestDecline(@RequestParam(value = "id") Integer requestId) {
        bookBean.deleteBookRentRequestsById(requestId);
    }
}
