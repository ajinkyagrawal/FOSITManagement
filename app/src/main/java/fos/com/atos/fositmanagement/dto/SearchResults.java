package fos.com.atos.fositmanagement.dto;

/**
 * Created by a596144 on 3/2/2017.
 */
public class SearchResults {
    private String name = "";
    private String cityState = "";
    private String phone = "";
    private String status = "";
    private String date = "";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCityState(String cityState) {
        this.cityState = cityState;
    }

    public String getCityState() {
        return cityState;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}