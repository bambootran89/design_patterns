/** Client: loads and demonstrates the Command pattern remote control. */
public class RemoteLoader {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    RemoteControl remoteControl = new RemoteControl();

    Light light = new Light();
    Stereo stereo = new Stereo();

    LightOnCommand lightOnCommand = new LightOnCommand(light);
    LightOffCommand lightOffCommand = new LightOffCommand(light);
    StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
    StereoOnWithCdCommand stereoOnWithCdCommand = new StereoOnWithCdCommand(stereo);
    StereoOnWithDvdCommand stereOnWithDvdCommand = new StereoOnWithDvdCommand(stereo);
    StereoOnWithRadioCommand stereoOnWithRadioCommand =
        new StereoOnWithRadioCommand(stereo);

    remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
    remoteControl.setCommand(1, stereoOnWithCdCommand, stereoOffCommand);
    remoteControl.setCommand(2, stereOnWithDvdCommand, stereoOffCommand);
    remoteControl.setCommand(3, stereoOnWithRadioCommand, stereoOffCommand);

    System.out.println(remoteControl);

    remoteControl.onButtonWasPushed(0);

    remoteControl.onButtonWasPushed(1);
    remoteControl.offButtonWasPushed(1);
    remoteControl.onButtonWasPushed(2);
    remoteControl.offButtonWasPushed(2);
    remoteControl.onButtonWasPushed(3);
    remoteControl.offButtonWasPushed(3);

    remoteControl.offButtonWasPushed(0);
  }
}
