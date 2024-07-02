public class Book
{
    private int id;
    private String name;
    private String issuedTo;
    private java.sql.Date issuedOn;
    private boolean pending;
    private boolean available;

    // Getters and Setters
    public int getId()
    {

        return id;
    }

    public void setId(int id)
    {

        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {

        this.name = name;
    }

    public String getIssuedTo()
    {
        return issuedTo;
    }
    public void setIssuedTo(String issuedTo)
    {
        this.issuedTo = issuedTo;
    }

    public java.sql.Date getIssuedOn()
    {
        return issuedOn;
    }

    public void setIssuedOn(java.sql.Date issuedOn)
    {
        this.issuedOn = issuedOn;
    }

    public boolean isPending()
    {
        return pending;
    }

    public void setPending(boolean pending)
    {
        this.pending = pending;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }
}
