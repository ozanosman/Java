import machines.Machine;
import managers.HeatManager;

import java.util.Scanner;

public class Application
{
    private final Scanner userInput = new Scanner(System.in);

    public void renderPower()
    {
        Machine machine1 = new Machine();
        Machine machine2 = new Machine();
        Machine machine3 = new Machine();

        Machine[] machines = new Machine[3];

        machines[0] = machine1;
        machines[1] = machine2;
        machines[2] = machine3;

        System.out.println("Въведете мощност на машините:");

        System.out.print("машина 1: ");
        machine1.setPower(userInput.nextInt());


        System.out.print("машина 2: ");
        machine2.setPower(userInput.nextInt());

        System.out.print("машина 3: ");
        machine3.setPower(userInput.nextInt());

        System.out.println("\nМощност на машина 1: " + machine1.getPower() +
                           "\nМощност на машина 2: " + machine2.getPower() +
                           "\nМощност на машина 3: " + machine3.getPower());
    }

    public void renderMaxWorkTemperature()
    {
        HeatManager heatManager1 = new HeatManager();

        HeatManager[] heatManager = new HeatManager[1];

        heatManager[0] = heatManager1;

        System.out.print("\nВъведете мощност на топлинния мениджър: ");
        heatManager1.setPower(userInput.nextInt());

        System.out.print("\nВъведете часове на работа за топлинния мениджър: ");
        heatManager1.setWorkHours(userInput.nextInt());

        System.out.println("\nМаксимална работна температура на топлинния менижър: " + heatManager1.getMaxWorkTemperature() + "°C");
    }
}
