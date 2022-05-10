package edu.miu.springdata.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String operation;
    private long duration;

    public ActivityLog(LocalDate date, String operation, long duration) {
        this.date = date;
        this.operation = operation;
        this.duration = duration;
    }
}