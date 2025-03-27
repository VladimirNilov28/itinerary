package org.example.prettifier.itinerary.model;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * 📌 Lombok Cheat Sheet (аннотации)
 *
 * <table border="1">
 *   <caption>Основные аннотации Lombok</caption>
 *   <tr>
 *     <th>Аннотация</th>
 *     <th>Описание</th>
 *     <th>Комментарий</th>
 *   </tr>
 *   <tr>
 *     <td>{@code @Getter}</td>
 *     <td>Генерирует геттеры для всех полей</td>
 *     <td>Часто используется</td>
 *   </tr>
 *   <tr>
 *     <td>{@code @Setter}</td>
 *     <td>Генерирует сеттеры для всех полей</td>
 *     <td>Применяется избирательно</td>
 *   </tr>
 *   <tr>
 *     <td>{@code @Data}</td>
 *     <td>Геттеры + Сеттеры + ToString + Equals/HashCode + RequiredArgsConstructor</td>
 *     <td>Для DTO и моделей</td>
 *   </tr>
 *   <tr>
 *     <td>{@code @Value}</td>
 *     <td>Как @Data, но делает объект immutable (final)</td>
 *     <td>Для неизменяемых объектов</td>
 *   </tr>
 *   <tr>
 *     <td>{@code @Builder}</td>
 *     <td>Паттерн Builder — удобное создание объектов</td>
 *     <td>Очень полезно при создании DTO</td>
 *   </tr>
 *   <tr>
 *     <td>{@code @NoArgsConstructor}</td>
 *     <td>Конструктор без аргументов</td>
 *     <td>Нужен для сериализации</td>
 *   </tr>
 *   <tr>
 *     <td>{@code @AllArgsConstructor}</td>
 *     <td>Конструктор со всеми аргументами</td>
 *     <td>Упрощает инициализацию</td>
 *   </tr>
 *   <tr>
 *     <td>{@code @RequiredArgsConstructor}</td>
 *     <td>Конструктор для final и @NonNull полей</td>
 *     <td>Безопасная альтернатива AllArgs</td>
 *   </tr>
 *   <tr>
 *     <td>{@code @ToString}</td>
 *     <td>Генерирует метод toString()</td>
 *     <td>Можно исключить поля</td>
 *   </tr>
 *   <tr>
 *     <td>{@code @EqualsAndHashCode}</td>
 *     <td>Генерирует equals() и hashCode()</td>
 *     <td>Настраивается</td>
 *   </tr>
 *   <tr>
 *     <td>{@code @Slf4j}</td>
 *     <td>Добавляет логгер log</td>
 *     <td>Для логирования</td>
 *   </tr>
 *   <tr>
 *     <td>{@code @NonNull}</td>
 *     <td>Проверка на null в аргументах</td>
 *     <td>Кидает NPE</td>
 *   </tr>
 * </table>
 */

/*
* Сущность для подробной информации о маршруте
* */

@Data
public class Itinerary {
    private String name;
    private String iso;
    private String municipality;
    private String icao_code;
    private String iata_code;
    private ZonedDateTime dateTime;
}
