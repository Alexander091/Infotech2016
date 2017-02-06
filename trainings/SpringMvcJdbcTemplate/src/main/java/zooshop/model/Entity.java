package zooshop.model;

public abstract class Entity {


    private long objectId;
    private long parentId;
    private long objectTypeId;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(long objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    @Override
    public String toString(){
        return
                "Entity with id: "+this.objectId;

    }

}

