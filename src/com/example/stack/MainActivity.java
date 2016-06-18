package com.example.stack;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Stack;
import java.util.Vector;
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

         //final Vector numVec = new Vector();
         final Stack numVec = new Stack();
        
        Button pushBtn = (Button)findViewById(R.id.pushButton);        
        pushBtn.setOnClickListener(new OnClickListener(){
        	
        	@Override
        	public void onClick(View v)
        	{
        		EditText editText = (EditText)findViewById(R.id.editText1);
                String value = editText.getText().toString();
                
                if(value.matches(""))
                	return;
                
                Log.e("value","value is : "+value);
                
                TextView textView = (TextView)findViewById(R.id.textView1);
               if( numVec.size() < 3)
               {
            	  // numVec.add(value);
            	   numVec.push(value);
            	  // numStack.
            	   String textvalue = "" + value + " is pushed. [" ;            	   
            	   for(int i = 0; i< numVec.size();i++)
            	   {
            		   if(i == 0)
              			   textvalue += numVec.get(i)  ;
              		   else
              			 textvalue +=  " , " + numVec.get(i)  ;
            		   
            	   }
            	   textvalue += "]";
            	   textView.setText(textvalue);            	   
               }
               else 
              {
            	   textView.setText("Stack is Full");
                
               }
        	}
        	
        });
        
        
        Button popBtn = (Button)findViewById(R.id.popButton);
        
        popBtn.setOnClickListener(new OnClickListener(){
        	
        	@Override
        	public void onClick(View v)
        	{

        		TextView textView = (TextView)findViewById(R.id.textView1);
        		if(numVec.size() == 0)
        		{
        			textView.setText("Stack is empty");
        			
        		}
        		else
        		{
        		
	                
	               textView.setText("removed");
	        		
	        		
	        		 String textvalue = "" + numVec.get(numVec.size() - 1) + " is poped." ;
	        		 
	        		 if(numVec.size() - 1 == 0)
	        		 {
	        			 textvalue += "" + "stack is empty";	 
	        			 //numVec.remove(numVec.size() - 1);
	        			 numVec.pop();
	        		 }
	        		 else
	        		 {
	        			 textvalue +=" [" ;
	        			// numVec.remove(numVec.size() - 1);
	        			 numVec.pop();
		          	   for(int i = 0; i< numVec.size();i++)
		          	   {
		          		   if(i == numVec.size() -1)
		          			   textvalue += numVec.get(i) + "]" ;
		          		   else
		          			 textvalue +=  numVec.get(i) + "," ;
		          		   
		          	   }
	        		 }
	          	// textvalue += "]";
	          	   textView.setText(textvalue);
        		}
        	}
        	
        });
        
        Button exitBtn = (Button)findViewById(R.id.exitButton);
        exitBtn.setOnClickListener(new OnClickListener(){
        	
        	@Override
        	public void onClick(View v)
        	{
        		System.exit(0);
        	}
        });
        	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
