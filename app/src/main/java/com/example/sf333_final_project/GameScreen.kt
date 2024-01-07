package com.example.tictactoe

import Card
import Deck.cards
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GameScreen(
    viewModel: GameViewModel,
) {

    val state = viewModel.state
    val playerHand = remember { mutableStateListOf<Card>() }
    val dealerHand = remember { mutableStateListOf<Card>() }

//    viewModel.setUpBoard(state.currentTurn, cards, playerHand, dealerHand)
    LaunchedEffect(Unit) {
        viewModel.setUpBoard(state.currentTurn, cards, playerHand, dealerHand)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Black Jack ♠",
            fontSize = 55.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Text(
            text = "Dealer : ${viewModel.PointDealer}",
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Row for Dealer's cards
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            contentPadding = PaddingValues(start = 16.dp, top = 50.dp, end = 16.dp, bottom = 8.dp)
        ) {
            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    contentPadding = PaddingValues(start = 8.dp, end = 8.dp)
                ) {
                    items(dealerHand) { card ->
                        Box(
                            modifier = Modifier
                                .size(100.dp, 150.dp)
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                                .shadow(4.dp)
                        ) {
                            Text(
                                text = "${card.value} ${card.suit}",
                                modifier = Modifier.align(Alignment.Center),
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
//        LazyRow(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            contentPadding = PaddingValues(start = 8.dp, end = 8.dp)
//        ) {
//            items(dealerHand) { card ->
//
//                if (dealerHand.indexOf(card) == 1 && card.boolean == false) {
//                    card.boolean = true
//                    Box(
//                        modifier = Modifier
//                            .size(100.dp, 150.dp)
//                            .background(Color.Gray, shape = RoundedCornerShape(8.dp))
//                            .shadow(4.dp)
//                    )
//                } else {
//                    Box(
//                        modifier = Modifier
//                            .size(100.dp, 150.dp)
//                            .background(Color.White, shape = RoundedCornerShape(8.dp))
//                            .shadow(4.dp)
//                    ) {
//                        Text(
//                            text = "${card.value} ${card.suit}",
//                            modifier = Modifier.align(Alignment.Center),
//                            fontSize = 16.sp
//                        )
//                    }
//                }
//            }
//        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color.Black)
                .padding(vertical = 50.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .background(color = Color.Black)
                    .padding(vertical = 50.dp)
            ) {

            }
        }

        // Row for Player's cards
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            contentPadding = PaddingValues(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
        ) {
            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    contentPadding = PaddingValues(start = 8.dp, end = 8.dp)
                ) {
                    items(playerHand) { card ->
                        Box(
                            modifier = Modifier
                                .size(100.dp, 150.dp)
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                                .shadow(4.dp)
                        ) {
                            Text(
                                text = "${card.value} ${card.suit}",
                                modifier = Modifier.align(Alignment.Center),
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Player : ${viewModel.PointPlayer}",
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        viewModel.DealCard(playerHand , cards)
                    }
                ) {
                    Text(text = "HIT", fontSize = 16.sp)
                }

                Button(
                    onClick = { viewModel.stand(playerHand , dealerHand , cards) }
                ) {
                    Text(text = "STAND", fontSize = 16.sp)
                }
            }
            Text(
                text = "${viewModel.checkWin(playerHand, dealerHand, cards)}"
            )

            Row (

            ){
                if (viewModel.hasWon) {
                    Row(
                    ) {
                    }
                    Button(
                        onClick = { viewModel.handlePlayAgain(playerHand,dealerHand)}
                    ) {
                        Text(text = "New Game", fontSize = 16.sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    GameScreen(viewModel())
}
