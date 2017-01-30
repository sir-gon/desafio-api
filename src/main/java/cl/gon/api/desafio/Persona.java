/*
 * @author Gonzalo Diaz <devel@gon.cl>
 *
 * Sources:
 * * Age calculation: http://howtodoinjava.com/for-fun-only/java-code-to-calculate-age-from-date-of-birth/
 * * Date-time string format: http://stackoverflow.com/a/12167395/6366150
 */

package cl.gon.api.desafio;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.LocalDate;
import org.joda.time.PeriodType;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;


@XmlRootElement
public class Persona {

  public String run;
  public String nombre;
  public String fechaNacimiento;
  public String sexo;
  public int ageYears;
  public int ageMonths;
  public int ageDays;

  public Persona() {
  }

  public Persona(String run, String nombre, String fechaNacimiento, String sexo) {
    this.run = run;
    this.nombre = nombre;
    this.fechaNacimiento = fechaNacimiento;
    this.sexo = sexo;
  }

  public Persona calcularEdad(String fechaNacimiento) {
    // temporal hardcoded values


    try {
        String pattern = "yyyy-MM-dd";

        LocalDate birthdate = LocalDate.parse(fechaNacimiento, DateTimeFormat.forPattern(pattern));

        LocalDate now = new LocalDate();                    //Today's date
        Period period = new Period(birthdate, now, PeriodType.yearMonthDay());

        this.ageYears   = period.getYears();
        this.ageMonths  = period.getMonths();
        this.ageDays    = period.getDays();

    } catch (Exception pe) {
        pe.printStackTrace();
    }

    return this;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }

      Persona that = (Persona) o;

      if (run != null ? !run.equals(that.run) : that.run != null) {
          return false;
      }

      if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) {
          return false;
      }

      if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null) {
          return false;
      }

      if (sexo != null ? !sexo.equals(that.sexo) : that.sexo != null) {
          return false;
      }
      return true;
  }

  /*
  @Override
  public int hashCode() {
      int result = run != null ? run.hashCode() : 0;
      result = 31 * result + b;
      result = 31 * result + (int) (c ^ (c >>> 32));
      return result;
  }
  */
}
