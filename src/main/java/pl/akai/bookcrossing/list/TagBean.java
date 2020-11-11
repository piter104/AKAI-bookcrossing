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

    public void insertNewTags(String newTags, Book book) {
        String[] tagNames = newTags.split("[,]", 0);
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

    public void insertExistingTags(String existingTags, Book book) {
        String[] tagNames = existingTags.split("[,]", 0);
        for (String name : tagNames) {
            Tag existingTag = bookBean.getTagByName(name);
            if (!book.getTagList().contains(existingTag)) {
                book.addTag(existingTag);
                bookBean.insertBookTag(book.getId(), existingTag.getId());
            }
        }
    }
}
