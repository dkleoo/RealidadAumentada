package com.example.realidadaumentada.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.example.realidadaumentada.BasicRenderer
import com.example.realidadaumentada.R
import com.example.realidadaumentada.api.request.ProductsModel
import org.rajawali3d.view.ISurface
import org.rajawali3d.view.SurfaceView

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Products() {

    var showModel by remember { mutableStateOf(false) }
    val products = listOf(
        ProductsModel("Manzana", "Manzan verde", 1.0, "",""),
        ProductsModel("Manzana", "Manzan verde", 1.0, "",""),
        ProductsModel("Manzana", "Manzan verde", 1.0, "",""),
        ProductsModel("Manzana", "Manzan verde", 1.0, "",""),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
    ) {
        items(products) { product ->
            Column (
                modifier = Modifier.padding(16.dp)
            ) {
                Card (
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable {
                            showModel = !showModel
                        },
                    elevation = CardDefaults.elevatedCardElevation(12.dp),
                ) {
                    AsyncImage(
                        model = product.image,
                        contentDescription = null,
                        error = painterResource(id = R.drawable.ic_place_holder),
                        placeholder = painterResource(id = R.drawable.ic_place_holder),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toString()
                )
            }
        }
    }

    if(showModel) {
        Surface {
            AndroidView(
                factory = { context ->
                    val surface = SurfaceView(context).apply {
                        setFrameRate(60.0)
                        renderMode = ISurface.RENDERMODE_WHEN_DIRTY
                    }
                    val renderer = BasicRenderer(context)
                    surface.setSurfaceRenderer(renderer)

                    surface
                },
                modifier = Modifier
                    .width(250.dp)
                    .height(250.dp)
            )
        }
    }

}