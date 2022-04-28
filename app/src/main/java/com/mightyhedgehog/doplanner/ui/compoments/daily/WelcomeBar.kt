package com.mightyhedgehog.doplanner.ui.compoments.daily

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.domain.model.user.User
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun WelcomeBar(user: User, modifier: Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.temp_avatar),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(style = DoPlannerTheme.typography.welcomeBarStyle, text = buildAnnotatedString {
            append("Hello, ")
            pushStyle(style = SpanStyle(fontWeight = FontWeight.Bold))
            append(user.name)
        })
    }
}

@Composable
@Preview
fun WelcomeBarPreview() {
    val userName = "Cody"
    DoPlannerTheme {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.temp_avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(style = DoPlannerTheme.typography.welcomeBarStyle, text = buildAnnotatedString {
                append("Hello, ")
                pushStyle(style = SpanStyle(fontWeight = FontWeight.Bold))
                append(userName)
            })
        }
    }
}
