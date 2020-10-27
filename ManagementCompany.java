public class ManagementCompany {
    private int MAX_PROPERTY;
    private int MGMT_WIDTH;
    private int MGMT_DEPTH;
    private double mgmFeePer;
    private String name;
    private String taxID;
    private Property[] properties;
    private Plot plot;
    private int propIndx = -1;

    /**
     * NO-arg Constructor creates ManagementCompnay object using empty strings.
     * plot set to plot with x=0,y=0,width=10,depth=10
     */
    public ManagementCompany() {
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        name = "";
        taxID = "";
    }

    /**
     * Creates mgmtComp using passed info
     * plot is set with x,y=0 and width,depth=10;
     *
     * @param name
     * @param taxID
     * @param mgmFeePer
     */
    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    /**
     * CREATES A AMANGENTCOMPANY USING PASSESD INFO
     *
     * @param name
     * @param taxID
     * @param mgmFee
     * @param x
     * @param y
     * @param width
     * @param depth
     */
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y,
                             int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(x, y, width, depth);
    }

    /**
     * copy constructor
     *
     * @param otherCompany
     */
    public ManagementCompany(ManagementCompany otherCompany) {
        MAX_PROPERTY = otherCompany.MAX_PROPERTY;
        MGMT_WIDTH = otherCompany.MGMT_WIDTH;
        MGMT_DEPTH = otherCompany.MGMT_DEPTH;
        properties = otherCompany.properties;
        plot = otherCompany.plot;
        name = otherCompany.name;
        taxID = otherCompany.taxID;
        mgmFeePer = otherCompany.mgmFeePer;
    }

    /**
     * creates a property object by copying from another property
     * adds to the properties array
     *
     * @param property
     * @return
     */
    public int addProperty(Property property) {
        int i = propIndx;
        int newIndx = propIndx + 1;
        if (newIndx >= this.MAX_PROPERTY) {
            return -1;
        } //check if the array is full

        this.properties[newIndx] = new Property(property);
        propIndx = newIndx;
        return newIndx;
    }

    /**
     * creates a property object with a default plot and adds it to the properties array
     *
     * @param name
     * @param city
     * @param rent
     * @param owner
     * @return
     */
    public int addProperty(String name, String city, double rent, String owner) {
        int i = propIndx;
        int newIndx = propIndx + 1;
        if (newIndx >= this.MAX_PROPERTY) {
            return -1;
        } //check if the array is full

        this.properties[newIndx] = new Property(name, city, rent, owner);
        propIndx = newIndx;
        return newIndx;
    }

    /**
     * creates property object and adds it to the properties array returns
     *
     * @param name
     * @param city
     * @param rent
     * @param owner
     * @param x
     * @param y
     * @param width
     * @param depth
     * @return int
     */
    public int addProperty(String name, String city, double rent, String owner,
                           int x, int y, int width, int depth) {
        int index = propIndx;
        int newIndx = propIndx + 1;
        Plot newPlot = new Plot(x, y, width, depth);

        if (newIndx >= this.MAX_PROPERTY) {
            return -1;
        }
        if (properties[index] == null) {
            return -2;
        }
        if (this.plot.encompasses(newPlot) == false) {
            return -3;
        }
        if (index >= 0) {
            for (int j = 0; j < this.properties.length; j++) {
                if (this.properties[j] == null) {
                    continue;
                }
                if (this.properties[j].getPlot().overlaps((newPlot)) == true) {
                    return -4;
                }
            }
        }
        this.properties[newIndx] = new Property(name, city, rent, owner, x, y, width, depth);

        propIndx = newIndx;
        return newIndx;
    }

    /**
     * displasy the info fo the property at index i
     * @param i
     * @return
     */
    public String displayPropertyAtIndex(int i) {
        return properties[i].toString();
    }

    /**
     * return max_property constant that represents the size of the properties
     * @return
     */
    public int getMAX_PROPERTY() {
        return MAX_PROPERTY;
    }

    /**
     * return name
     * @return
     */
    public String getName() {
        return name;
    }

    public Plot getPlot() {
        return new Plot(plot);
    }

    /**
     * this method finds a property within the properties array that has the amximum rent
     * @return rent amount
     */

    public double maxRentProp() {

    return properties[maxRentPropertyIndex()].getRentAmount();
    }

    public int maxRentPropertyIndex() {
        double maxRent = 0;
        int maxIndex = -1;

        for (int i = 1; i < this.properties.length; i++) {
            if (properties[i] == null) {continue;}
            if (properties[i].getRentAmount() > maxRent) {
                maxRent = properties[i].getRentAmount();
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    public String toString() {
        String str = "";
        for (int i = 0; i < properties.length; i++) {
            str += properties[i].toString() + "\n";
        }
        return "List of the properties for " + getName() + "taxID: " + taxID +
                "\n________________________________________\n" +
                str +
                "\n________________________________________\ntotal management Fee: "+ totalRent();

    }
    double totalRent() {
        double total = 0;
        for (int i = 0; i < properties.length; i++) {
            if (this.properties[i] == null) {
                continue;
            }
            total += properties[i].getRentAmount();
        }
        return total;
    }
}