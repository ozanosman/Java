package managers;

import machines.Machine;

public class HeatManager extends Machine
{
    private int workHours;

    public int getWorkHours()
    {
        return workHours;
    }

    public void setWorkHours(int workHours)
    {
        this.workHours = workHours;
    }

    public int getMaxWorkTemperature()
    {
        return ((getWorkHours() * getPower()) / 2);
    }
}
