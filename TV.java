public class TV {
    private String brand;
    private int size;
    private boolean isOn;

    public TV(String brand, int size) {
        this.brand = brand;
        this.size = size;
        this.isOn = false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Телевизор " + brand + " включен.");
        } else {
            System.out.println("Телевизор " + brand + " уже включен.");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Телевизор " + brand + " выключен.");
        } else {
            System.out.println("Телевизор " + brand + " уже выключен.");
        }
    }

    public void changeChannel(int channel) {
        if (isOn) {
            System.out.println("Телевизор " + brand + " переключен на канал " + channel);
        } else {
            System.out.println("Телевизор " + brand + " выключен. Включите его для смены канала.");
        }
    }
}
// проверка
