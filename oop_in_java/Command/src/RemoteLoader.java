/** Client: loads and demonstrates the Command pattern remote control. */
public class RemoteLoader {

  /** @param args */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    RemoteControl remoteControl = new RemoteControl();

    Light light = new Light();
    Stereo stereo = new Stereo();

    LightOnCommand lightOnCommand = new LightOnCommand(light);
    LightOffCommand lightOffCommand = new LightOffCommand(light);
    StereoOffCommamd stereoOffCommand = new StereoOffCommamd(stereo);
    StereoOnWithCdCommamd stereoOnWithCdCommand = new StereoOnWithCdCommamd(stereo);
    StereoOnWithDvdCommamd stereOnWithDvdCommamd = new StereoOnWithDvdCommamd(stereo);
    StereoOnWithRadioCommamd stereoOnWithRadioCommamd = new StereoOnWithRadioCommamd(stereo);

    remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
    remoteControl.setCommand(1, stereoOnWithCdCommand, stereoOffCommand);
    remoteControl.setCommand(2, stereOnWithDvdCommamd, stereoOffCommand);
    remoteControl.setCommand(3, stereoOnWithRadioCommamd, stereoOffCommand);

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
