package com.example.evaluacion1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF8F9FA)
                ) {
                    PerfilRedSocialScreen()
                }
            }
        }
    }
}

@Composable
fun PerfilRedSocialScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 1. CARD PRINCIPAL: Perfil con imagen real
        PerfilCard()

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Fotos compartidas",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color(0xFF1F2937)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 2. LAZY ROW: 8 imágenes horizontales
        FotosCompartidasHorizontalList()

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Pasatiempos Favoritos",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color(0xFF1F2937)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 3. LAZY COLUMN: 10 pasatiempos verticales
        PasatiemposVerticalList()
    }
}

@Composable
fun PerfilCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFECEFF1)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Foto de perfil circular usando la imagen 'fp.jpg'
                Image(
                    painter = painterResource(id = R.drawable.fp),
                    contentDescription = "Foto de perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                // Datos de la persona
                Column {
                    Text(
                        text = "Juan Pablo Ibarra",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFF212121)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "21 años • Guadalajara, Jalisco",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "Programador, Fotógrafo y Aventurero",
                        fontSize = 12.sp,
                        color = Color(0xFF555555)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botones de acción
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.height(38.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Mensaje", fontSize = 13.sp)
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { },
                    modifier = Modifier.height(38.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5))
                ) {
                    Text("Seguir", fontSize = 13.sp, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun FotosCompartidasHorizontalList() {
    // Referencia a las 8 imágenes renombradas en res/drawable
    val fotos = listOf(
        R.drawable.img11,
        R.drawable.img22,
        R.drawable.img33,
        R.drawable.img44,
        R.drawable.img55,
        R.drawable.img66,
        R.drawable.img77,
        R.drawable.img88
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(fotos) { _, imagenResId ->
            Image(
                painter = painterResource(id = imagenResId),
                contentDescription = "Foto compartida",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}

@Composable
fun PasatiemposVerticalList() {
    // 10 pasatiempos temáticos
    val pasatiempos = listOf(
        "📸 Fotografía de atardeceres y paisajes",
        "🏔️ Senderismo en montaña y campismo",
        "✈️ Viajar a lugares turísticos y playas",
        "🎸 Tocar la guitarra en momentos libres",
        "☕ Probar cafés de especialidad",
        "🏃‍♂️ Correr al aire libre por las mañanas",
        "📖 Leer libros sobre naturaleza y viajes",
        "🚗 Hacer viajes por carretera (roadtrips)",
        "🎨 Edición digital de fotografías",
        "🌌 Observación astronómica de estrellas"
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(pasatiempos) { index, pasatiempo ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "${index + 1}. $pasatiempo",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF424242)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfilRedSocialPreview() {
    MaterialTheme {
        PerfilRedSocialScreen()
    }
}