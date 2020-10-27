import sun.management.snmp.AdaptorBootstrap;

public class Property {
    private java.lang.String city;
    private double rentAmount;
    private java.lang.String owner;
    private java.lang.String propertyName;
    private Plot plot;

    public Property () {
        city = "";
        rentAmount = 0;
        owner = "";
        propertyName = "";
        this.plot = new Plot();
    }
    public Property(Property p) {
        this.city = p.city;
        this.rentAmount = p.rentAmount;
        this.owner = p.owner;
        this.propertyName = p.propertyName;
        this.plot = new Plot(p.plot);
    }
    public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner= owner;
        this.plot = new Plot();
    }
    public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner,
                    int x, int y, int width, int depth )
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }
    public java.lang.String getPropertyName() {
        return propertyName;
    }
    public void setPropertyName(java.lang.String propertyName) {
        this.propertyName = propertyName;
    }
    public java.lang.String getCity() {
        return city;
    }
    public void setPlot(int x, int y, int width, int depth) {
        plot.setWidth(width);
        plot.setDepth(depth);
        plot.setX(x);
        plot.setY(y);
    }
    public Plot getPlot() {
        return new Plot(plot);
    }
    public void setCity(java.lang.String city) {
        this.city = city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Property Name: " +
                "\nLocated in: " + city + '\'' +
                "\nrentAmount=" + rentAmount +
                "\nowner='" + owner + '\'' +
                "\npropertyName='" + propertyName + '\'' +
                "\nplot=" + plot;
    }
}
