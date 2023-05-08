package swe206;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class methods {
  

  public static long daysBetween(LocalDate startDate, LocalDate endDate) {
    return ChronoUnit.DAYS.between(startDate, endDate);
}

  public static void main(String[] args) {
    LocalDate startDate = LocalDate.of(2021, 1, 1);
    LocalDate endDate = LocalDate.of(2021, 1, 10);
    long daysBetween = daysBetween(startDate, endDate);
    System.out.println("Days between " + startDate + " and " + endDate + ": " + daysBetween);
  }

  // public void changeToTournamentPage() {

  // }
}
