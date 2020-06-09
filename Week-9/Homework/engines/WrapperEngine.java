package engines;

import managers.HeatManager;

public class WrapperEngine extends HeatManager
{
    public WrapperEngine(int power)
    {
        this.setPower(power);
    }
}
