package pl.akai.bookcrossing.list;

import org.springframework.stereotype.Component;
import pl.akai.bookcrossing.model.Book;
import pl.akai.bookcrossing.model.Tag;

import java.util.Set;

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
                    bookBean.insertBookTag(book.getId(), tag.getId());
                } else {
                    book.getResponse().addTagId(tag.getId());
                }
            }
        }
    }

    public void insertExistingTags(Book book) {
        Set<Integer> existingTagsList = book.getResponse().getExistingTagsList();
        if (existingTagsList != null) {
            for (Integer tagId : existingTagsList) {
                bookBean.insertBookTag(book.getId(), tagId);
            }
        }
    }
}
