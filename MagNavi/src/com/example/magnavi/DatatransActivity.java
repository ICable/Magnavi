package com.example.magnavi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import com.magnavi.util.mag_protocol;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DatatransActivity extends Activity
{
  TextView resultTextView,sendmessage;
  mag_protocol mag_protocol;
  BluetoothAdapter adapter;
  private final static String MY_UUID = "00001101-0000-1000-8000-00805F9B34FB";   //SPP����UUID��
  BluetoothDevice _device = null;     //�����豸
  BluetoothSocket _socket = null;      //����ͨ��socket
  private InputStream blueStream;    //������������������������
  private OutputStream outstream;
  myHandler mmhandler;
  public boolean flag_rec_thread=false;
  public static byte[] result = new byte[1024];

  
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_datatrans_);
		resultTextView=(TextView)findViewById(R.id.result_text);
		sendmessage=(TextView)findViewById(R.id.setmessage);
		mag_protocol=new mag_protocol();
		
//		��ȡϵͳĬ������
		adapter = BluetoothAdapter.getDefaultAdapter();
		getThread.start();//�߳�����  
		mmhandler = new myHandler();
		
	}

	public void onstart(View v)
	{
//		ֱ�Ӵ�����
		adapter.enable();
//		��ʼ����
	//	adapter.startDiscovery();
		_device = adapter.getRemoteDevice("81:F2:6D:98:0E:A0");
        // �÷���ŵõ�socket
        try{
        	_socket = _device.createRfcommSocketToServiceRecord(UUID.fromString(MY_UUID));
        }catch(IOException e){
//        	Toast.makeText(this, "����ʧ�ܣ�", Toast.LENGTH_SHORT).show();
        }
        try
		{	
			_socket.connect();
			Log.i("SOCKET", "����"+_device.getName()+"�ɹ���");
			resultTextView.setText("���ӳɹ�");
			//Toast.makeText(this, "����"+_device.getName()+"�ɹ���", Toast.LENGTH_SHORT).show();
		} catch (IOException e)
		{
			
    		try
			{
//    		Toast.makeText(this, "����ʧ�ܣ�", Toast.LENGTH_SHORT).show();
			_socket.close();
			resultTextView.setText("��������");
			_socket = null;
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
//				Toast.makeText(this, "����ʧ�ܣ�", Toast.LENGTH_SHORT).show();	
			}            		
			// TODO Auto-generated catch block
			return;
		}

        //�򿪽����߳�
        try{
    		blueStream = _socket.getInputStream();   //�õ���������������
    		//blueoutOutputStream=_socket.getOutputStream();//�õ������������
//    		Toast.makeText(this, "���������ɹ�", Toast.LENGTH_SHORT).show();
    		}catch(IOException e){
//    			Toast.makeText(this, "��������ʧ�ܣ�", Toast.LENGTH_SHORT).show();
    			return;
    		}
		 
	}
	public void onclickins1(View v)
	{

		
		try{
			byte ins1[]=mag_protocol.get_mag_power_status1(0, 1);
			sendmessage.setText(ByteToString(ins1));

//			String output = ByteToString(ins1);
//			byte []bs=new byte[1024];
//			String sendoutput = output;
//			bs = getHexBytes(output);
			outstream = _socket.getOutputStream();
			outstream.write(ins1); 
		}catch(IOException e) {  
            
        }  
		
		flag_rec_thread=true;
		if (flag_rec_thread)
		{
			resultTextView.setText("���ڽ���");
		}else {
			resultTextView.setText("ֹͣ����");
		}
 
	}
	
	public void onclickins2(View v)
	{

		try{
			byte ins2[]=mag_protocol.get_mag_power_status2(0, 1);
			sendmessage.setText(ByteToString(ins2));

//			String output = ByteToString(ins1);
//			byte []bs=new byte[1024];
//			String sendoutput = output;
//			bs = getHexBytes(output);
			outstream = _socket.getOutputStream();
			outstream.write(ins2); 
		}catch(IOException e) {  
            
        }  
			
			flag_rec_thread=true;
			if (flag_rec_thread)
			{
				resultTextView.setText("���ڽ���");
			}else {
				resultTextView.setText("ֹͣ����");
			}
		 
	}
	public void onclickins3(View v)
	{

		try{
			byte ins3[]=mag_protocol.get_mag_power_status3(0, 1);
			sendmessage.setText(ByteToString(ins3));

//			String output = ByteToString(ins1);
//			byte []bs=new byte[1024];
//			String sendoutput = output;
//			bs = getHexBytes(output);
			outstream = _socket.getOutputStream();
			outstream.write(ins3); 
		}catch(IOException e) {  
            
        }  
			
			flag_rec_thread=true;
			if (flag_rec_thread)
			{
				resultTextView.setText("���ڽ���");
			}else {
				resultTextView.setText("ֹͣ����");
			}
		 
	}
	public void onclickins4(View v)
	{

		try{
			byte ins4[]=mag_protocol.get_mag_power_status4(0, 1);
			sendmessage.setText(ByteToString(ins4));

//			String output = ByteToString(ins1);
//			byte []bs=new byte[1024];
//			String sendoutput = output;
//			bs = getHexBytes(output);
			outstream = _socket.getOutputStream();
			outstream.write(ins4); 
		}catch(IOException e) {  
            
        }  
			
			flag_rec_thread=true;
			if (flag_rec_thread)
			{
				resultTextView.setText("���ڽ���");
			}else {
				resultTextView.setText("ֹͣ����");
			}
		 
	}
	public void onclickins5(View v)
	{

		try{
			byte ins5[]=mag_protocol.get_mag_power_status5(0, 1);
			sendmessage.setText(ByteToString(ins5));

//			String output = ByteToString(ins1);
//			byte []bs=new byte[1024];
//			String sendoutput = output;
//			bs = getHexBytes(output);
			outstream = _socket.getOutputStream();
			outstream.write(ins5); 
		}catch(IOException e) {  
            
        }  
			
			flag_rec_thread=true;
			if (flag_rec_thread)
			{
				resultTextView.setText("���ڽ���");
			}else {
				resultTextView.setText("ֹͣ����");
			}
		 
	}
	public void onclickins6(View v)
	{

		try{
			byte ins6[]=mag_protocol.get_mag_power_status6(0, 1);
			sendmessage.setText(ByteToString(ins6));

//			String output = ByteToString(ins1);
//			byte []bs=new byte[1024];
//			String sendoutput = output;
//			bs = getHexBytes(output);
			outstream = _socket.getOutputStream();
			outstream.write(ins6); 
		}catch(IOException e) {  
            
        }  
			
			flag_rec_thread=true;
			if (flag_rec_thread)
			{
				resultTextView.setText("���ڽ���");
			}else {
				resultTextView.setText("ֹͣ����");
			}
		 
	}
	public void onclear(View v){
		resultTextView.setText("");

	}
	
	public static String ByteToString(byte[] bytes)

	{

	String returnString="";

	for (int i = 0; i < bytes.length; i++)
	{
		returnString+= Integer.toHexString(bytes[i]&0xff)+" ";
	}
	
		return returnString ;

	}
	
	public class myHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			if(msg.what == 0x123){ 
				String text;
				text = (String) msg.obj;
				resultTextView.setText(text);  
            }  
			super.handleMessage(msg);
		}
	}

	Thread getThread =new Thread(){
		@Override
		public void run() {
			
			while (!currentThread().isInterrupted()) {
				String rec="";
				if(flag_rec_thread)
				{
					try{
						blueStream = _socket.getInputStream();
						int num;
						byte[] buffer =new byte[1024];
						num = blueStream.read(buffer);
						for(int j =0;j<12;j++){
							for(int i = 0 ; i < num; i++)
							{ 		  
							//readMessage[i]=String.format("%2x", bytes[i-count]);	
							rec+=Integer.toHexString(buffer[i]&0xff);
							}
						}
						
						
						
						Message message = mmhandler.obtainMessage();  
			            message.what = 0x123;  
			            message.obj = rec;  
			           
			            mmhandler.sendMessage(message);  
					}catch(IOException e) {  
		                break;  
		            }  
					
					try
					{
						sleep(100);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
			
			
			 
		}
	};
	private byte[] getHexBytes(String message) {
        int len = message.length() / 2;
        char[] chars = message.toCharArray();
        String[] hexStr = new String[len];
        byte[] bytes = new byte[len];
        for (int i = 0, j = 0; j < len; i += 2, j++) {
            hexStr[j] = "" + chars[i] + chars[i + 1];
            bytes[j] = (byte) Integer.parseInt(hexStr[j], 16);
        }
        return bytes;
    }
}
