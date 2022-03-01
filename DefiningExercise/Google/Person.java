package src.DefiningExercise.Google;


import java.util.ArrayList;
import java.util.List;

public class Person {

     private Company company;
     private Car car;
     private List<Parent> parents;
     private List<Children> children;
     private List<Pokemon> pokemon;

     public List<Parent> getParents() {
          return parents;
     }

     public List<Children> getChildren() {
          return children;
     }

     public List<Pokemon> getPokemon() {
          return this.pokemon;
     }

     public void setCar(Car car) {
          this.car = car;
     }

     public Person() {

          this.parents = new ArrayList<>();
          this.children = new ArrayList<>();
          this.pokemon = new ArrayList<>();

     }

     public Person(Company company, Car car, List<Parent> parents, List<Children> children, List<Pokemon> pokemon) {
          this.company = company;
          this.car = car;
          this.parents = parents;
          this.children = children;
          this.pokemon = pokemon;
     }

     public void setCompany(Company company) {
          this.company = company;
     }

     @Override

     public String toString() {
          StringBuilder stringBuilder = new StringBuilder();

          stringBuilder.append("Company:").append(System.lineSeparator());
          if (company != null) {
               stringBuilder.append(company).append(System.lineSeparator());
          }
          stringBuilder.append("Car:").append(System.lineSeparator());
          if (car != null) {
               stringBuilder.append(car).append(System.lineSeparator());
          }
          stringBuilder.append("Pokemon:").append(System.lineSeparator());

          for (Pokemon poks : pokemon) {
               stringBuilder.append(poks).append(System.lineSeparator());
          }
          stringBuilder.append("Parents:").append(System.lineSeparator());
          for (Parent parent : parents) {
               stringBuilder.append(parent).append(System.lineSeparator());
          }
          stringBuilder.append("Children:").append(System.lineSeparator());
          for (Children child : children) {
               stringBuilder.append(child).append(System.lineSeparator());
          }
          return stringBuilder.toString();
     }
}
