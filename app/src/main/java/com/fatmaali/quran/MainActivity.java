package com.fatmaali.quran;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview_menu);
        TextView textView =(TextView) findViewById(R.id.text_title);
        String[] items = getResources().getStringArray(R.array.index);
        ArrayAdapter arrayAdapter= new ArrayAdapter <String> (this,R.layout.row_items,R.id.textView_item,items);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Web_html.class);
                intent.putExtra("page",i);
                startActivity(intent);
            }
        });

    }

    public void img_share(View view) {
        String txtshare="Quran El-Qarem";
        String linkshare ="https://play.google.com/store/apps/details?id=com.fatmaali.quran";
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txtshare+"\n"+linkshare);
        startActivity(share);
    }

    public void img_more(View view) {
        Intent morapp = new Intent(Intent.ACTION_VIEW);
        String morlink="https://play.google.com/store/apps/developers?id=fatma94";
        morapp.setData(Uri.parse(morlink));
        startActivity(morapp);
    }

    public void img_email(View view) {
        try {
            String txt=" this is my suggestion ";
            Intent emailshare = new Intent(Intent.ACTION_SEND);
            emailshare.setData(Uri.parse("mailto"));
            emailshare.setType("message/rfc822");
            String[] email ={"fatmaaliibrahim1994@yahoo.com","fatmaaliibrahim2015@gmail.com"};
            emailshare.putExtra(Intent.EXTRA_EMAIL,email);
            emailshare.putExtra(Intent.EXTRA_SUBJECT,"Quran");
            emailshare.putExtra(Intent.EXTRA_TEXT,txt);
//        Intent chooser =Intent.createChooser(emailshare,"launch Email");
//        startActivity(chooser);
            startActivity(emailshare);
        }
       catch (Exception e){
           Toast.makeText(this,"No found this app",Toast.LENGTH_LONG).show();
       }
    }

    public void img_close(View view) {
        finish();
    }
}
