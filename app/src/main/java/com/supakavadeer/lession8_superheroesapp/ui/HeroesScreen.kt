package com.supakavadeer.lession8_superheroesapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.supakavadeer.lession8_superheroesapp.HeroApp
import com.supakavadeer.lession8_superheroesapp.R
import com.supakavadeer.lession8_superheroesapp.ui.theme.Lession8_SuperheroesAppTheme

@Composable
fun HeroLayout(
    @DrawableRes heroIcon: Int,
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .padding(16.dp, 8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_small))
                .size(dimensionResource(R.dimen.image_size))
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(heroName),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(heroDescription),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.image_size))
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Image(
                    modifier = modifier
                        .fillMaxHeight()
                        .clip(MaterialTheme.shapes.small),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(heroIcon),
                    contentDescription = null
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroPreview() {
    Lession8_SuperheroesAppTheme(darkTheme = false) {
        HeroApp()
    }
}

@Preview(showBackground = true)
@Composable
fun HeroDarkThemePreview() {
    Lession8_SuperheroesAppTheme(darkTheme = true) {
        HeroApp()
    }
}