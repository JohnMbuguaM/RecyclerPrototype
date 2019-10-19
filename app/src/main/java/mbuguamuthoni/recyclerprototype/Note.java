package mbuguamuthoni.recyclerprototype;


import java.util.Date;


public class Note {
    private String no_plate, nickName;
    private int number;
    public Date timestamp;


    public Note() {
        //empty constructor
    }


    public Note(String nickName, String no_plate) {
        this.number = number;
        this.no_plate = no_plate;
        this.nickName = nickName;




    }


    public Date getTimestamp() {
        return timestamp;
    }


    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getNo_plate() {
        return no_plate;
    }

    public String getNickName() {
        return nickName;
    }

//    public String getTime() {
//        return time;
//    }

    public int getNumber() {
        return number;
    }





}
