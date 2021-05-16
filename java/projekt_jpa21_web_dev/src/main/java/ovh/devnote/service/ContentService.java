package ovh.devnote.service;

import ovh.devnote.DAO.ContentDao;
import ovh.devnote.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

    @Autowired
    private ContentDao contentDao;

    public void saveContent(Content content) {
        contentDao.save(content);
    }


}
