package com.metacoders.home;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeErrorDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.metacoders.home.bookMarkController.bookmarkActivity;
import com.metacoders.home.loginandSetup.loginactivity;
import com.metacoders.home.model.modelForBookMark;

public class postDetails_for_Career_prep_by_subject extends AppCompatActivity {
        TextView mTitleTv , mDetailTv ;
        AdView mAdView ,madview_below ;

    DrawerLayout drawerLayout ;
    ActionBarDrawerToggle toggle ;
    NavigationView navigationView ;
    AlertDialog alertDialog ;
    DatabaseReference mref ;
    FirebaseAuth mauth ;
    String  uid , title , desc ;
    Boolean ispressed = false ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_post_details_for__career_prep_by_subject);

        mauth = FirebaseAuth.getInstance();


        //ad implement
        mAdView = findViewById(R.id.adView_post_details_for_carer_prep_bySbjest);
        madview_below =findViewById(R.id.adView_postdestail_postDeatils_BYSubject);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        madview_below.loadAd(adRequest);
        drawerLayout = findViewById(R.id.drawerId_carrerer_prep_by_subject);
        navigationView=findViewById(R.id.NAVVIew_ID_carrer_prep_by_subject);

        toggle = new ActionBarDrawerToggle(this,drawerLayout ,R.string.nav_open ,R.string.nav_close );


        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.cakRi_menu:
                        Intent i = new Intent(getApplicationContext() ,PostsListActivity.class);
                        startActivity(i);
                        break;
                    case R.id.Bcs_prep_menu:
                        Intent bcs = new Intent(getApplicationContext() ,BcsButtonActivity.class);
                        startActivity(bcs);
                        break;
                    case R.id.bookmark_menu:
                        i = new Intent(getApplicationContext(), bookmarkActivity.class);
                        startActivity(i);
                        break;

                    case R.id.profile_menu:
                        i = new Intent(getApplicationContext(), profileActivity.class);
                        startActivity(i);
                        break;
                    case R.id.job_prep_menu:
                        Intent jobprep = new Intent(getApplicationContext() , CareerPrepActivity.class);
                        startActivity(jobprep);
                        break;
                    case R.id.Bank_prep_menu:
                        Intent Bank = new Intent(getApplicationContext() ,Bank_Prep.class);
                        startActivity(Bank);
                        break;
                    case R.id.Govt_job_prep_menu:
                        Intent gob = new Intent(getApplicationContext() ,Govt_job_prep.class);
                        startActivity(gob);
                        break;
                    case R.id.Others_prep_menu:
                        Intent others = new Intent(getApplicationContext() ,career_prep_Others.class);
                        startActivity(others);
                        break;
                    case R.id.noticeBoard_prep_menu:
                        Intent notiice = new Intent(getApplicationContext() ,ArticleActivity.class);
                        startActivity(notiice);
                        break;
                    case R.id.bises_prep_menu:
                        Intent bises = new Intent(getApplicationContext() ,Bises.class);
                        startActivity(bises);
                        break;
                    case R.id.Quiz_prep_menu:
                        Intent quiz = new Intent(getApplicationContext() ,QuizActivity.class);
                        startActivity(quiz);
                        break;
                    case R.id.Samprotik_prep_menu:
                        Intent sam = new Intent(getApplicationContext() ,Current_Activity.class);
                        startActivity(sam);
                        break;
                    case R.id.Voca_prep_menu:
                        Intent voca = new Intent(getApplicationContext() ,Voca_activity.class);
                        startActivity(voca);
                        break;
                    case R.id.Edotorial_prep_menu:
                        Intent edo = new Intent(getApplicationContext() ,Editorial.class);
                        startActivity(edo);
                        break;
                    case R.id.Shop_prep_menu:
                        Intent shop = new Intent(getApplicationContext() ,Shop.class);
                        startActivity(shop);
                        break;
                    case R.id.contact_us_menu:
                        Intent con = new Intent(getApplicationContext() ,ContactActivity.class);
                        startActivity(con);
                        break;
                    case R.id.Rate_menu:
                        try{
                            startActivity(new Intent(Intent.ACTION_VIEW ,
                                    Uri.parse("market://details?id=" + getPackageName())));

                        } catch (ActivityNotFoundException e){

                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName() ) ));

                        }
                        break;


                }
                return false;
            }
        });





        //Action bar
        ActionBar actionBar = getSupportActionBar();
        //Actionbar title
        actionBar.setTitle("Post Detail");
        //set back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //initialize views
        mTitleTv = findViewById(R.id.titleTv_postDetails_car_prep);
        mDetailTv = findViewById(R.id.descriptionTv_postDetails_car_prep);
        //get data from intent
         title = getIntent().getStringExtra("title");
         desc = getIntent().getStringExtra("description");
        //set data to views
        mTitleTv.setText(title);
        mDetailTv.setText(desc);
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        if(toggle.onOptionsItemSelected(item)){
            return  true ;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.bookmarkmenu, menu);
        MenuItem item = menu.findItem(R.id.bookmark_btn);
        MenuItem item1 = menu.findItem(R.id.font_btn) ;

        item1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                resizeTheFont() ;


                return false;
            }
        }) ;

        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if ( isUserSignedIn())
                {
                    if (ispressed){
                        Toast.makeText(getApplicationContext() , "You All Ready Added This", Toast.LENGTH_SHORT).show();
                    }
                    else  {
                        uploadPostToServer();

                    }

                }


                else {

                    triggerWarningDialouge();
                }


                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }
    private void resizeTheFont() {

        CharSequence[] textSize = {"Normal","Large","Extra Large"};
        // Toast.makeText(getApplicationContext() , "CLOCKED" , Toast.LENGTH_SHORT).show();


        AlertDialog.Builder builder = new AlertDialog.Builder(postDetails_for_Career_prep_by_subject.this,R.style.DialogTheme);
        builder.setTitle("Select Text Size");
        builder.setSingleChoiceItems(textSize, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                switch (item){
                    case 0:
                        mDetailTv.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
                        break;
                    case 1:
                        //  dView.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                        mDetailTv.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                        break;
                    case 2:
                        mDetailTv.setTextSize(TypedValue.COMPLEX_UNIT_SP,23);
                        break;
                }
                alertDialog.dismiss();
            }
        });
        alertDialog=builder.create();
        alertDialog.show();

    }
    private void uploadPostToServer() {

        uid  =FirebaseAuth.getInstance().getUid() ;
        mref = FirebaseDatabase.getInstance().getReference("Users").child(uid).child("bookmarks");
        String ts = mref.push().getKey();

        modelForBookMark model = new modelForBookMark(title , "nulld" , desc, ts);
        mref.child(ts).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                ispressed= true ;


                Toast.makeText(getApplicationContext() , "Added To The Bookmark ", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                ispressed= false;

                Toast.makeText(getApplicationContext() , "Network Error!! Could Not Save The Data  ", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public    boolean  isUserSignedIn() {
        FirebaseAuth mauth  = FirebaseAuth.getInstance();
        FirebaseUser user = mauth.getCurrentUser() ;

        return user != null;



    }
    public  void triggerWarningDialouge() {
        new AwesomeErrorDialog(postDetails_for_Career_prep_by_subject.this)
                .setTitle("Error!!!")
                .setMessage("You Are Not Allowed To Do This Action.Please Login first . ")
                .setColoredCircle(R.color.dialogErrorBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white)
                .setCancelable(true)
                .setButtonText(getString(R.string.dialog_ok_button))
                .setButtonBackgroundColor(R.color.dialogErrorBackgroundColor)
                .setButtonText("Proceed To Login")
                .setErrorButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        // click

                        Intent io = new Intent(getApplicationContext(), loginactivity.class);
                        startActivity(io);



                    }
                })
                .show();

    }


}
