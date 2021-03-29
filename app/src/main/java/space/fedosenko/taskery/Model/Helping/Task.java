package space.fedosenko.taskery.Model.Helping;

import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {
    private int id;
    private String name, description;
    private boolean isDone = false;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Task(String name) {
        this.name = name;

    }

    protected Task(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    public void changeState(){
        isDone= !isDone;
    }

    public boolean isDone(){
        return isDone;
    }




    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
    }
}
