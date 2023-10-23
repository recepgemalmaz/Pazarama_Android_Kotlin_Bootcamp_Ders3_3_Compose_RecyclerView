package com.recepgemalmaz.pazarama_bootcamp_ders_3_3_jackpack_compose_recyclerview


import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocal
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.recepgemalmaz.pazarama_bootcamp_ders_3_3_jackpack_compose_recyclerview.ui.theme.Pazarama_Bootcamp_Ders_3_3_Jackpack_Compose_RecyclerviewTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pazarama_Bootcamp_Ders_3_3_Jackpack_Compose_RecyclerviewTheme {
                // A surface container using the 'background' color from the theme
                MainScr()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScr() {
    Scaffold(topBar = {Title() },
    )
    {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        )
        {
            ListeGoruntule(lst = GunlukVeriler().Get())
        }
    }
}

@Composable
fun ListeGoruntule(lst: List<Finans>)
{
    LazyColumn(contentPadding = PaddingValues(3.dp) )
    {
        items(lst)
        {
            ElemanGoster(it)
        }
    }
}

@Composable
fun ElemanGoster(f:Finans)
{
    var context  = LocalContext.current

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.LightGray)
        .clickable(
            enabled = true, onClickLabel = "Detay Göster"
        ) {
            var t = Toast.makeText(context, "Seçilen: ${f.isim}", Toast.LENGTH_LONG)
            t.setGravity(Gravity.TOP, 0, 100)
            t.show()
        },
        Arrangement.Top , Alignment.CenterHorizontally
    )
    {
        Text(text = f.isim,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(1.dp),
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(1.5.dp))

        Text(text = "${f.deger} TL",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(1.dp),
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(1.5.dp))

        Text(text = f.tarih,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(1.dp),
            fontWeight = FontWeight.Light
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Title()
{
    TopAppBar(title = { Text("Günlük Finansal Veriler") },
        Modifier
            .fillMaxWidth()
            .background(Color.Blue))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pazarama_Bootcamp_Ders_3_3_Jackpack_Compose_RecyclerviewTheme {
        // Title()
        // ElemanGoster(f = Finans("Afyon Dinarı", 50.03F, "21.10.23"))
    }
}