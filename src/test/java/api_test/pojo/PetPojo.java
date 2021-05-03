package api_test.pojo;

import java.util.List;
import java.util.Map;

public class PetPojo {
    private long id;
    private Map<String , Integer> category;
    private String name;
    private List<String> photoUrls;
    private List<Object> tags;
    private String status;

    public long getId() {
        return id;
    }
    public Map<String, Integer> getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public List<String> getPhotoUrls() {
        return photoUrls;
    }
    public List<Object> getTags() {
        return tags;
    }
    public String getStatus() {
        return status;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setCategory(Map<String, Integer> category) {
        this.category = category;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }
    public void setStatus(String status) {
        this.status = status;
    }


}
