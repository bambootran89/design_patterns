
public class client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Sony sony = new Sony();
        RCATv rcaTv = new RCATv();
        
        ConcreateRemote concreateRemoteforSony =  new ConcreateRemote(sony);
        ConcreateRemote concreateRemoteforRCATv =  new ConcreateRemote(rcaTv);
        
        concreateRemoteforRCATv.on();
        concreateRemoteforRCATv.setChannel(1);
        
        concreateRemoteforRCATv.setChannel(134);
        concreateRemoteforRCATv.nextChannel();
        concreateRemoteforRCATv.previousChannel();
        
        concreateRemoteforRCATv.off();
        
        concreateRemoteforSony.on();
        concreateRemoteforSony.setChannel(20202);
        
        concreateRemoteforSony.setChannel(200);
        concreateRemoteforSony.nextChannel();
        concreateRemoteforSony.previousChannel();
        
        concreateRemoteforSony.off();
	}

}
