package hackathon.rpi2;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.springframework.stereotype.Component;


@Component
public class LedControl {
    final GpioPinDigitalOutput pinGreen;

    final GpioPinDigitalOutput pinRed;
    final GpioController gpio = GpioFactory.getInstance();

    {
        pinGreen = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "green");
        pinRed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "red");

    }



    public void green() {
        try {
            run(pinGreen);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //@Scheduled(fixedDelay = 7000)
    public void doMagic() {


        try {


            run(pinGreen);
            run(pinRed);

           // gpio.shutdown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void run(GpioPinDigitalOutput pin) throws InterruptedException {
        System.out.println("<--Pi4J--> GPIO Control Example ... started.");

        // create gpio controller

        // provision gpio pin #01 as an output pin and turn on

        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);

        System.out.println("--> GPIO state should be: ON");

        pin.high();

        Thread.sleep(2000);

        // turn off gpio pin #01
        pin.low();
        System.out.println("--> GPIO state should be: OFF");


        System.out.println("Exiting ControlGpioExample");

    }

    private void red() throws InterruptedException {
        System.out.println("<--Pi4J--> GPIO Control Example ... started.");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #01 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "green", PinState.HIGH);

        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);

        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(2000);

        // turn off gpio pin #01
        pin.low();
        System.out.println("--> GPIO state should be: OFF");

        gpio.shutdown();

        System.out.println("Exiting ControlGpioExample");
    }


}
