package pl.akai.bookcrossing.list;

import org.springframework.stereotype.Component;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Tag;

@Component
public class TagBean {
    private final BookBean bookBean;

    public TagBean(BookBean bookBean) {
        this.bookBean = bookBean;
    }

    public void insertNewTags(Book book) {
        String newTags = book.getResponse().getNewTags();
        if (newTags != null) {
            String[] tagNames = newTags.split(",");
            for (String name : tagNames) {
                Tag tag = new Tag();
                tag.setName(name.trim());
                Tag existingTag = bookBean.getTagByName(tag.getName());
                if (existingTag == null && tag.getName().length() != 0) {
                    bookBean.insertTag(tag);
                    book.addTag(tag);
                    bookBean.insertBookTag(book.getId(), tag.getId());
                }
            }
        }
    }

    public void insertExistingTags(Book book) {
        String existingTags = book.getResponse().getExistingTagsList();
        if (existingTags.length() != 0) {
            String[] existingTagNames = existingTags.split(",");
            for (String name : existingTagNames) {
                Tag existingTag = bookBean.getTagByName(name);
                bookBean.insertBookTag(book.getId(), existingTag.getId());
            }
        }
    }
}
