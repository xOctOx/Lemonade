# Lemonade App

Une petite application Android développée avec **Kotlin** et **Jetpack Compose**.
L'application simule les différentes étapes de préparation d'une limonade à travers une interface simple et interactive.

## Présentation

L'application permet à l'utilisateur de cliquer sur une image afin de passer progressivement par différentes étapes :

1. Sélectionner un citron sur l'arbre
2. Presser le citron
3. Boire la limonade
4. Recommencer

Une fois la dernière étape atteinte, un clic permet de revenir au début.

## Technologies utilisées

* Kotlin
* Android
* Jetpack Compose
* Material 3
* Android Studio

## Fonctionnement

L'application utilise une variable d'état :

```kotlin
var etat by remember { mutableStateOf(1) }
```

Cette variable permet de déterminer quelle étape de l'application doit être affichée.

### Gestion des étapes

```kotlin
val images = when (etat) {
    1 -> R.drawable.lemon_tree
    2 -> R.drawable.lemon_squeeze
    3 -> R.drawable.lemon_drink
    4 -> R.drawable.lemon_restart
    else -> R.drawable.lemon_tree
}
```

Chaque valeur de `etat` correspond à une image différente.

### Interaction

L'image est rendue interactive grâce à `clickable` :

```kotlin
.clickable {
    if (etat == 4) {
        etat = 1
    } else {
        etat = etat + 1
    }
}
```

Le cycle des états est donc :

```text
1 → 2 → 3 → 4 → 1
```

## Interface

L'interface est composée de :

* Une barre supérieure contenant le nom de l'application
* Une image représentant l'étape actuelle
* Un texte descriptif
* Une zone cliquable permettant de changer d'étape

## Structure principale

Le projet utilise notamment les composants Compose suivants :

```text
Column
Box
Image
Text
Spacer
Modifier
clickable
background
clip
```

L'état de l'application est géré avec :

```text
remember
mutableStateOf
```

## Installation

### 1. Cloner le projet

```bash
git clone <URL_DU_REPOSITORY>
```

### 2. Ouvrir le projet

Ouvrir le projet avec **Android Studio**.

### 3. Synchroniser Gradle

Attendre la synchronisation automatique de Gradle.

### 4. Lancer l'application

Utiliser un émulateur Android ou un appareil Android physique, puis cliquer sur **Run**.

## Prérequis

Pour exécuter le projet, il est recommandé d'avoir :

* Android Studio
* JDK compatible avec la version du projet
* Android SDK
* Un émulateur Android ou un smartphone Android

## Objectif pédagogique

Ce projet permet de pratiquer les notions fondamentales de **Jetpack Compose**, notamment :

* La création d'interfaces avec Compose
* Les `Composable`
* La gestion d'état avec `remember`
* `mutableStateOf`
* Les expressions `when`
* Les événements `clickable`
* Les `Modifier`
* L'utilisation des ressources `drawable` et `string`
* L'organisation d'une interface avec `Column` et `Box`

## Amélioration possible

Une amélioration possible serait de modifier l'étape de pression du citron afin de demander plusieurs clics avant de passer à l'étape suivante.

Par exemple :

```text
Citron
  ↓
Clic
  ↓
Clic
  ↓
Clic
  ↓
Limonade
```

Cela permettrait de reproduire plus fidèlement le comportement de l'application Lemonade originale.

## Auteur

Projet réalisé dans le cadre de l'apprentissage du développement Android avec **Kotlin et Jetpack Compose**.
