# SI_lab2_196078
## Кодот од програмата:
```java
import java.util.ArrayList;
import java.util.List;

class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {

    public List<Integer> function(List<Time> timesList) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < timesList.size(); i++) { // B.1, B.2, B.3
            int hr = timesList.get(i).getHours();
            int min = timesList.get(i).getMinutes();
            int sec = timesList.get(i).getSeconds();
            if (hr < 0 || hr > 24){ // C
                if (hr < 0){ // D
                    throw new RuntimeException("The hours are smaller than the minimum"); // E
                }
                else {
                    throw new RuntimeException("The hours are grater than the maximum"); // F
                }
            }
            else if (hr < 24) { // G
                if (min < 0 || min > 59) // H
                    throw new RuntimeException("The minutes are not valid!"); // I
                else {
                    if (sec >= 0 && sec <= 59) // J
                        result.add(hr * 3600 + min * 60 + sec); // L
                    else
                        throw new RuntimeException("The seconds are not valid"); // M
                }
            } 
            else if (hr == 24 && min == 0 && sec == 0) { // N
                    result.add(hr * 3600 + min * 60 + sec); // O
            } 
            else {
                throw new RuntimeException("The time is greater than the maximum"); // P
            }
        }
        return result; // Q
    }
}
```
## Control Flow Graph
Слика од графот на контрола:

![alt text](https://github.com/Dekibuki/SI_lab2_196078/raw/master/ControlFlow.png "Control Flow Graph")

## Цикломатската комплексност 
Формулата за комплексност P + 1 (предикатни јазли + 1) дава комплексност 7 + 1 = 8. 

## Multiple Condition тестови
Овие тестови имаат за цел да ги проверат условните јазли кои се составени од повеќе подуслови. Тоа би биле јазлите: C, H, J, N
Прво за условот C:
```java
if (hr < 0 || hr > 24)
```
| **Combination** | **Test Case** | **Branch** |
| --- | --- | --- |
| TX | (Time(-2, 0, 0)) | C-D
| FT | (Time(25, 61, 61)) | C-D
| FF | (Time(2, -1, -1)) | C-G

Следно за условот H:
```java
if (min < 0 || min > 59)
```
| **Combination** | **Test Case** | **Branch** |
| --- | --- | ---|
| TX | (Time(2, -1, -1)) | H-I
| FT | (Time(20, 61, 61)) | H-I
| FF | (Time(2, 1, 1)) | H-J

Следно за условот Ј:
```java
if (sec >= 0 && sec <= 59) 
```
| **Combination** | **Test Case** | **Branch** |
| --- | --- | ---|
| FX | (Time(2, 1, -1)) | J-M
| TF | (Time(20, 30, 61)) | J-M
| TT | (Time(2, 1, 1)) | J-L

На крај да го провериме условот N:
```java
else if (hr == 24 && min == 0 && sec == 0)
```
| **Combination** | **Test Case** | **Branch** |
| --- | --- | ---|
| FXX | (Time(2, 1, 1)) | N-P
| TFX | (Time(24, 1, 1)) | N-P
| TTF | (Time(24, 0, 1)) | N-P
| TTT | (Time(24, 0, 0)) | N-O

## C1 - Every Branch Тестови
Со овие тестови намената е да ги изминеме сите гранки од графот.

| Branches | Time(24, 0, 0) | Time(24, 59, 0) | Time(2, 61, 0) | Time(2, 30, 61) | Time(2, 30, 25) | Time(-1, 0, 0) | Time(25, 0, 0) |
| --- | --- | --- | --- | --- | --- | --- | --- |
| B.1-B.2 | * | * | * | * | * | * | * |
| B.2-Q | * | / | / | / | * | / | / |
| B.2-C | * | * | * | * | * | * | * |
| C-D | / | / | / | / | / | * | * |
| D-E | / | / | / | / | / | * | / |
| D-F | / | / | / | / | / | / | * |
| C-G | * | * | * | * | * | / | / |
| G-H | / | / | * | * | * | / | / |
| H-I | / | / | * | / | / | / | / |
| H-J | / | / | / | * | * | / | / |
| J-L | / | / | / | / | * | / | / |
| J-M | / | / | / | * | / | / | / |
| L-B.3 | / | / | / | / | * | / | / |
| B.3-B.2 | * | / | / | / | * | / | / |
| G-N | * | * | / | / | / | / | / |
| N-O | * | / | / | / | / | / | / |
| N-P | / | * | / | / | / | / | / |
| O-B.3 | * | / | / | / | / | / | / |
Потребни се минимум 7 тест примери за да се изминат сите гранки во графот.


