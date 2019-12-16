package com.kisler.artesiete;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String webViewUrl = "http://trasgo.net/";
    private WebView webView;
    private String currentUrl = "";
    private Map<String, String> extraHeaders = new HashMap<String, String>();
    private boolean canGoBack = false;
    private boolean esUnEnlace = false;
    private FloatingActionMenu menu;
    private FloatingActionButton menu_item_lol, menu_item_csgo, menu_item_cod, menu_item_clash_royale, menu_item_home;
    private RelativeLayout cargando, contenedorPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        menu = (FloatingActionMenu) findViewById(R.id.menu);
        menu_item_lol = (FloatingActionButton) findViewById(R.id.menu_item_lol);
        menu_item_csgo = (FloatingActionButton) findViewById(R.id.menu_item_csgo);
        menu_item_cod = (FloatingActionButton) findViewById(R.id.menu_item_cod);
        menu_item_clash_royale = (FloatingActionButton) findViewById(R.id.menu_item_clash_royale);
        menu_item_home = (FloatingActionButton) findViewById(R.id.menu_item_home);

        cargando = (RelativeLayout) findViewById(R.id.cargando);
        contenedorPrincipal = (RelativeLayout) findViewById(R.id.contenedorPrincipal);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        webView = (ObservableWebView) findViewById(R.id.webView);
        extraHeaders.put("X-Requested-With", "");
        webView.setWebViewClient(new Callback());
        webView.loadUrl(webViewUrl, extraHeaders);
        webView.clearCache(true);

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            findViewById(R.id.shadow_view).setVisibility(View.GONE);
        }



        contenedorPrincipal.setVisibility(View.INVISIBLE);
        cargando.setVisibility(View.VISIBLE);



        menu_item_lol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cargando.setVisibility(View.VISIBLE);
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(1000);
                cargando.setAnimation(animation);

                menu.close(true);

                canGoBack = true;
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        webView.loadUrl("http://trasgo.net/contenido/lol-noticias-general");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        menu_item_csgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cargando.setVisibility(View.VISIBLE);
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(1000);
                cargando.setAnimation(animation);

                menu.close(true);

                canGoBack = true;
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        webView.loadUrl("http://trasgo.net/contenido/csgo-general");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        menu_item_cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cargando.setVisibility(View.VISIBLE);
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(1000);
                cargando.setAnimation(animation);

                menu.close(true);

                canGoBack = true;
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        webView.loadUrl("http://trasgo.net/contenido/bo2-general");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        menu_item_clash_royale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargando.setVisibility(View.VISIBLE);
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(1000);
                cargando.setAnimation(animation);

                menu.close(true);

                canGoBack = true;
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        webView.loadUrl("http://trasgo.net/contenido/cr-general");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        menu_item_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cargando.setVisibility(View.VISIBLE);
                Animation animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setDuration(1000);
                cargando.setAnimation(animation);

                menu.close(true);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        webView.loadUrl("http://trasgo.net/");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }

    private class Callback extends WebViewClient
    {
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {

            if (request.getUrl().getEncodedPath().contains(".css")) {
                ContentResolver contentResolver = getApplication().getContentResolver();
                return new WebResourceResponse(contentResolver.getType(request.getUrl()), "UTF-8", getResources().openRawResource(R.raw.style));
            }

            return null;
        }

        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final String url) {

            if (url.equalsIgnoreCase("http://trasgo.net/")){
                canGoBack=false;
            }else {
                canGoBack=true;
            }


            esUnEnlace = true;


            cargando.setVisibility(View.VISIBLE);
            Animation animation = new AlphaAnimation(0.0f, 1.0f);
            animation.setDuration(1000);
            cargando.setAnimation(animation);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    cargando.setVisibility(View.VISIBLE);
//                    Animation animation2 = new AlphaAnimation(1.0f, 0.0f);
//                    animation2.setDuration(1000);
//                    cargando.setAnimation(animation2);
//                    cargando.setVisibility(View.GONE);
                    view.loadUrl(url, extraHeaders);

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            return true;

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

        }

        @Override
        public void onPageFinished(final WebView view,final String url) {

            webView.zoomBy(0.1f);

            if (!esUnEnlace){
                contenedorPrincipal.setVisibility(View.VISIBLE);
            }

            //cargando.setVisibility(View.INVISIBLE);

            new CountDownTimer(1000, 1000) {

                public void onTick(long millisUntilFinished) {

                    //here you can have your logic to set text to edittext
                }

                public void onFinish() {

                    Animation animation = new AlphaAnimation(1.0f, 0.0f);
                    animation.setDuration(1000);
                    cargando.setAnimation(animation);
                    cargando.setVisibility(View.GONE);


                    currentUrl = url;

                    view.loadUrl("javascript:HTMLOUT.processHTML(document.documentElement.outerHTML);");
                }

            }.start();





        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            contenedorPrincipal.setVisibility(View.INVISIBLE);
            cargando.setVisibility(View.VISIBLE);

            error(failingUrl, "Problemas de conexión", "Ha habido un problema en la conexión. ¿Desea volver a conectar?");
        }
    }

    private void error(final String url, final String title, final String subtitle)
    {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(subtitle)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        webView.loadUrl(url, extraHeaders);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }

    @Override
    public void onBackPressed()
    {
        if(canGoBack)
        {
            webView.loadUrl("http://trasgo.net/");
            canGoBack=false;
        }
        else
        {
            super.onBackPressed();
        }
    }
}
