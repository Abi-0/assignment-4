public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        x = 0;
        y = 0;
        width = 1;
        depth = 1;
    }
    public Plot(Plot p) {
        x = p.x;
        y = p.y;
        width = p.width;
        depth = p.depth;
    }
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }
    public boolean overlaps(Plot plot) {
        return x < plot.x + plot.width && x + width > plot.x && y < plot.y + plot.depth && y + depth > plot.y;
    }
    public boolean encompasses(Plot plot) {
        int result = 0;
        int p1x1 = this.getX(); // starting x coord (left)
        int p2x1 = plot.getX();
        int p1x2 = this.getX() + this.getWidth(); // ending x coord (right)
        int p1y1 = this.getY(); // starting y coord (top)
        int p2y1 = plot.getY();
        int p1y2 = this.getY() + this.getDepth(); // ending y coord (bottom)

        // Checks
        if (p1x1 + this.getWidth() > p2x1) { result = 1; }
        if (p1y1 + this.getDepth() > p2y1) { result = 1; }
        if (p1x1 >= p2x1 || p2x1 <= p1x2) { result = 1; }
        if (p1y1 >= p2y1 || p2y1 <= p1y2) { result = 1; }

        System.out.println("Encompasses: this.X" + p1x1 + " P.X " + p2x1);

        // Return
        return result == 0 ? false : true;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
    public int getDepth() {
        return depth;
    }
}
