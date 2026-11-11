public class Radio {
    private int currentStation;
    private int currentVolume;
    private int stationsCount; // Количество станций

    // Конструктор без параметров (по умолчанию 10 станций)
    public Radio() {
        this.stationsCount = 10;
    }

    // Конструктор с параметром (задаем количество станций)
    public Radio(int stationsCount) {
        this.stationsCount = stationsCount;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int newStation) {
        // Проверяем, что номер станции в допустимых пределах
        if (newStation >= 0 && newStation < stationsCount) {
            currentStation = newStation;
        }
    }

    public void next() {
        if (currentStation == stationsCount - 1) {
            currentStation = 0; // Переход с последней на первую
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationsCount - 1; // Переход с первой на последнюю
        } else {
            currentStation--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}