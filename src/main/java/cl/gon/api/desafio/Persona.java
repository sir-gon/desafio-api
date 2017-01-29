/*
 * @author Gonzalo Diaz <devel@gon.cl>
 */

package cl.gon.api.desafio;

import javax.xml.bind.annotation.XmlRootElement;

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
    this.ageYears   = 10;
    this.ageMonths  = 4;
    this.ageDays    = 30;

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
