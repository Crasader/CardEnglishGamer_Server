package org.kteam.service;

import org.kteam.dao.form.AppointmentForm;
import org.kteam.entity.Appointment;


public interface AppointmentService {
  int appoint(AppointmentForm record);
  int returnBook(Appointment record);
}
