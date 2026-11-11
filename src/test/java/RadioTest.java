import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    // --- ТЕСТЫ ДЛЯ 10 СТАНЦИЙ (по умолчанию) ---

    @Test
    public void shouldSetValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetInvalidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(10); // Невалидное значение (максимум 9)
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.next();
        Assertions.assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchFromMaxToMinStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prev();
        Assertions.assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchFromMinToMaxStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    // --- НОВЫЕ ТЕСТЫ ДЛЯ КОНСТРУКТОРА С ПАРАМЕТРОМ (например, 30 станций) ---

    @Test
    public void shouldSetValidStationForCustomCount() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(15);
        Assertions.assertEquals(15, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetInvalidStationForCustomCount() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(30); // Невалидное (максимум 29)
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchFromMaxToMinForCustomCount() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(29); // Максимальная для 30 станций
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchFromMinToMaxForCustomCount() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(0);
        radio.prev();
        Assertions.assertEquals(29, radio.getCurrentStation());
    }

    // --- ТЕСТЫ ГРОМКОСТИ ---

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        Assertions.assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotExceedMaxVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        radio.increaseVolume(); // 101-й раз
        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotGoBelowMinVolume() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }
}