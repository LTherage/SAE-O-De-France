<div id="top">

<!-- HEADER STYLE: BANNER -->
<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 800 200">
	<defs>
		<linearGradient id="bg" x1="0%" y1="0%" x2="100%" y2="100%">
			<stop offset="0%" style="stop-color:#5b2de5;stop-opacity:1" />
			<stop offset="50%" style="stop-color:#c92de5;stop-opacity:1" />
			<stop offset="100%" style="stop-color:#e52d92;stop-opacity:1" />
		</linearGradient>
		<filter id="shadow">
			<feDropShadow dx="2.0" dy="2.0" stdDeviation="4.0" flood-opacity="0.5" />
		</filter>
		<pattern id="dots" width="20.0" height="20.0" patternUnits="userSpaceOnUse">
			<circle cx="3" cy="3" r="1.5" fill="rgba(255,255,255,0.2)" />
		</pattern>
	</defs>
	<rect width="100%" height="100%" fill="url(#bg)" rx="5.0" />
	<rect width="100%" height="100%" fill="url(#dots)" />
	<circle cx="64.0" cy="50.0" r="30.0" fill="rgba(255,255,255,0.8)" />
	<circle cx="736.0" cy="150.0" r="40.0" fill="rgba(255,255,255,0.8)" />
	<path d="M 400.0 25.0
			 L 450.0 75.0
			 L 350.0 75.0 Z" fill="rgba(255,255,255,0.8)" />
	<text x="400.0" y="100.0" font-family="Arial, sans-serif" font-size="24" font-weight="bold" text-anchor="middle" fill="#FFFFFF" filter="url(#shadow)">
		SAE-O-De-France
	</text><br>
	<text x="400.0" y="150.0" font-family="Arial, sans-serif" font-size="18" text-anchor="middle" fill="rgba(255,255,255,0.9)">
</text></svg>

<!-- BADGES -->
<img src="https://img.shields.io/github/license/LTherage/SAE-O-De-France?style=flat-square&logo=opensourceinitiative&logoColor=white&color=00BFFF" alt="license">
<img src="https://img.shields.io/github/last-commit/LTherage/SAE-O-De-France?style=flat-square&logo=git&logoColor=white&color=00BFFF" alt="last-commit">
<img src="https://img.shields.io/github/languages/top/LTherage/SAE-O-De-France?style=flat-square&color=00BFFF" alt="repo-top-language">
<img src="https://img.shields.io/github/languages/count/LTherage/SAE-O-De-France?style=flat-square&color=00BFFF" alt="repo-language-count">

<em>Built with the tools and technologies:</em>

<img src="https://img.shields.io/badge/Org-77AA99.svg?style=flat-square&logo=Org&logoColor=white" alt="Org">
<img src="https://img.shields.io/badge/Gradle-02303A.svg?style=flat-square&logo=Gradle&logoColor=white" alt="Gradle">
<img src="https://img.shields.io/badge/XML-005FAD.svg?style=flat-square&logo=XML&logoColor=white" alt="XML">
<img src="https://img.shields.io/badge/bat-31369E.svg?style=flat-square&logo=bat&logoColor=white" alt="bat">
<img src="https://img.shields.io/badge/CSS-663399.svg?style=flat-square&logo=CSS&logoColor=white" alt="CSS">

</div>

---

## 💎 Table of Contents

- [💎 Table of Contents](#-table-of-contents)
- [🔷 Overview](#-overview)
- [🔶 Features](#-features)
- [💠 Project Structure](#-project-structure)
    - [🔹 Project Index](#-project-index)
- [🔸 Getting Started](#-getting-started)
    - [🟦 Prerequisites](#-prerequisites)
    - [🟨 Installation](#-installation)
    - [🟧 Usage](#-usage)
    - [🟥 Testing](#-testing)
- [✨ Roadmap](#-roadmap)
- [⭐ Contributing](#-contributing)
- [💫 License](#-license)
- [✧ Acknowledgments](#-acknowledgments)

---

## 🔷 Overview

SAE-O-De-France est une application JavaFX de gestion d’une entreprise de distribution d’eau. Le projet implémente un système de gestion des clients, des commandes et des stocks, avec des règles de fidélité et de remise selon le type de client.

L’application est structurée autour d’un modèle métier Java et de vues FXML. Elle permet d’ajouter, modifier et consulter les informations liées aux particuliers, entreprises et établissements publics, ainsi que de gérer les lots d’eau stockés dans les entrepôts.

---

## 🔶 Features

<code>❯ Gestion complète du cycle de vente de l’eau en JavaFX.</code>

- Gestion des clients : particuliers, entreprises et établissements publics
- Gestion des commandes et des lignes de commande associées
- Suivi des stocks d’eau par catégorie et entrepôt
- Calcul de remises et de bouteilles gratuites selon le profil client
- Interface JavaFX avec navigation entre accueil, clients, commandes et stock
- Modélisation du domaine avec classes métier et tests unitaires JUnit

---

## 💠 Project Structure

```sh
└── SAE-O-De-France/
    ├── README.md
    ├── build
    │   ├── classes
    │   ├── distributions
    │   ├── libs
    │   ├── reports
    │   ├── resources
    │   ├── scripts
    │   ├── test-results
    │   └── tmp
    ├── build.gradle
    ├── gradle
    │   └── wrapper
    ├── gradlew
    ├── gradlew.bat
    ├── settings.gradle
    └── src
        ├── main
        └── test
```

### 🔹 Project Index

<details open>
	<summary><b><code>SAE-O-DE-FRANCE/</code></b></summary>
	<!-- __root__ Submodule -->
	<details>
		<summary><b>__root__</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ __root__</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/gradlew.bat'>gradlew.bat</a></b></td>
					<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build.gradle'>build.gradle</a></b></td>
					<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/settings.gradle'>settings.gradle</a></b></td>
					<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
				</tr>
			</table>
		</blockquote>
	</details>
	<!-- build Submodule -->
	<details>
		<summary><b>build</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ build</b></code>
			<!-- scripts Submodule -->
			<details>
				<summary><b>scripts</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ build.scripts</b></code>
					<table style='width: 100%; border-collapse: collapse;'>
					<thead>
						<tr style='background-color: #f8f9fa;'>
							<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
							<th style='text-align: left; padding: 8px;'>Summary</th>
						</tr>
					</thead>
						<tr style='border-bottom: 1px solid #eee;'>
							<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/scripts/SAE_dev2'>SAE_dev2</a></b></td>
							<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
						</tr>
						<tr style='border-bottom: 1px solid #eee;'>
							<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/scripts/SAE_dev2.bat'>SAE_dev2.bat</a></b></td>
							<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
						</tr>
					</table>
				</blockquote>
			</details>
			<!-- reports Submodule -->
			<details>
				<summary><b>reports</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ build.reports</b></code>
					<!-- problems Submodule -->
					<details>
						<summary><b>problems</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ build.reports.problems</b></code>
							<table style='width: 100%; border-collapse: collapse;'>
							<thead>
								<tr style='background-color: #f8f9fa;'>
									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
									<th style='text-align: left; padding: 8px;'>Summary</th>
								</tr>
							</thead>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/reports/problems/problems-report.html'>problems-report.html</a></b></td>
									<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
								</tr>
							</table>
						</blockquote>
					</details>
				</blockquote>
			</details>
			<!-- test-results Submodule -->
			<details>
				<summary><b>test-results</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ build.test-results</b></code>
					<!-- test Submodule -->
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ build.test-results.test</b></code>
							<table style='width: 100%; border-collapse: collapse;'>
							<thead>
								<tr style='background-color: #f8f9fa;'>
									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
									<th style='text-align: left; padding: 8px;'>Summary</th>
								</tr>
							</thead>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/test-results/test/TEST-fr.univartois.butinfo.sae.model.AdresseTest.xml'>TEST-fr.univartois.butinfo.sae.model.AdresseTest.xml</a></b></td>
									<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
								</tr>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/test-results/test/TEST-fr.univartois.butinfo.sae.model.EntrepotTest.xml'>TEST-fr.univartois.butinfo.sae.model.EntrepotTest.xml</a></b></td>
									<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
								</tr>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/test-results/test/TEST-fr.univartois.butinfo.sae.model.CommuneTest.xml'>TEST-fr.univartois.butinfo.sae.model.CommuneTest.xml</a></b></td>
									<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
								</tr>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/test-results/test/TEST-fr.univartois.butinfo.sae.model.CommandeTest.xml'>TEST-fr.univartois.butinfo.sae.model.CommandeTest.xml</a></b></td>
									<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
								</tr>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/test-results/test/TEST-fr.univartois.butinfo.sae.model.ClientTest.xml'>TEST-fr.univartois.butinfo.sae.model.ClientTest.xml</a></b></td>
									<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
								</tr>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/test-results/test/TEST-fr.univartois.butinfo.sae.model.EauTest.xml'>TEST-fr.univartois.butinfo.sae.model.EauTest.xml</a></b></td>
									<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
								</tr>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/test-results/test/TEST-fr.univartois.butinfo.sae.model.StockGlobalTest.xml'>TEST-fr.univartois.butinfo.sae.model.StockGlobalTest.xml</a></b></td>
									<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
								</tr>
							</table>
							<!-- binary Submodule -->
							<details>
								<summary><b>binary</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ build.test-results.test.binary</b></code>
									<table style='width: 100%; border-collapse: collapse;'>
									<thead>
										<tr style='background-color: #f8f9fa;'>
											<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
											<th style='text-align: left; padding: 8px;'>Summary</th>
										</tr>
									</thead>
										<tr style='border-bottom: 1px solid #eee;'>
											<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/test-results/test/binary/output.bin'>output.bin</a></b></td>
											<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
										</tr>
										<tr style='border-bottom: 1px solid #eee;'>
											<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/test-results/test/binary/results.bin'>results.bin</a></b></td>
											<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
										</tr>
										<tr style='border-bottom: 1px solid #eee;'>
											<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/test-results/test/binary/output.bin.idx'>output.bin.idx</a></b></td>
											<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
										</tr>
									</table>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
			<!-- resources Submodule -->
			<details>
				<summary><b>resources</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ build.resources</b></code>
					<!-- main Submodule -->
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ build.resources.main</b></code>
							<!-- fr Submodule -->
							<details>
								<summary><b>fr</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ build.resources.main.fr</b></code>
									<!-- univartois Submodule -->
									<details>
										<summary><b>univartois</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ build.resources.main.fr.univartois</b></code>
											<!-- butinfo Submodule -->
											<details>
												<summary><b>butinfo</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ build.resources.main.fr.univartois.butinfo</b></code>
													<!-- sae Submodule -->
													<details>
														<summary><b>sae</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ build.resources.main.fr.univartois.butinfo.sae</b></code>
															<!-- view Submodule -->
															<details>
																<summary><b>view</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ build.resources.main.fr.univartois.butinfo.sae.view</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/resources/main/fr/univartois/butinfo/sae/view/StockEauAjout&ModifView.fxml'>StockEauAjout&ModifView.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/resources/main/fr/univartois/butinfo/sae/view/StockEauView.fxml'>StockEauView.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/resources/main/fr/univartois/butinfo/sae/view/Commande-view.fxml'>Commande-view.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/resources/main/fr/univartois/butinfo/sae/view/FourmulaireClient.fxml'>FourmulaireClient.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/resources/main/fr/univartois/butinfo/sae/view/CommandeAjoutModif.fxml'>CommandeAjoutModif.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/resources/main/fr/univartois/butinfo/sae/view/Client-view.fxml'>Client-view.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/resources/main/fr/univartois/butinfo/sae/view/Accueil-view.fxml'>Accueil-view.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
			<!-- tmp Submodule -->
			<details>
				<summary><b>tmp</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ build.tmp</b></code>
					<!-- jar Submodule -->
					<details>
						<summary><b>jar</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ build.tmp.jar</b></code>
							<table style='width: 100%; border-collapse: collapse;'>
							<thead>
								<tr style='background-color: #f8f9fa;'>
									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
									<th style='text-align: left; padding: 8px;'>Summary</th>
								</tr>
							</thead>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/tmp/jar/MANIFEST.MF'>MANIFEST.MF</a></b></td>
									<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
								</tr>
							</table>
						</blockquote>
					</details>
					<!-- compileTestJava Submodule -->
					<details>
						<summary><b>compileTestJava</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ build.tmp.compileTestJava</b></code>
							<table style='width: 100%; border-collapse: collapse;'>
							<thead>
								<tr style='background-color: #f8f9fa;'>
									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
									<th style='text-align: left; padding: 8px;'>Summary</th>
								</tr>
							</thead>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/tmp/compileTestJava/previous-compilation-data.bin'>previous-compilation-data.bin</a></b></td>
									<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
								</tr>
							</table>
						</blockquote>
					</details>
					<!-- compileJava Submodule -->
					<details>
						<summary><b>compileJava</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ build.tmp.compileJava</b></code>
							<table style='width: 100%; border-collapse: collapse;'>
							<thead>
								<tr style='background-color: #f8f9fa;'>
									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
									<th style='text-align: left; padding: 8px;'>Summary</th>
								</tr>
							</thead>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/build/tmp/compileJava/previous-compilation-data.bin'>previous-compilation-data.bin</a></b></td>
									<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
								</tr>
							</table>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<!-- src Submodule -->
	<details>
		<summary><b>src</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ src</b></code>
			<!-- main Submodule -->
			<details>
				<summary><b>main</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ src.main</b></code>
					<!-- java Submodule -->
					<details>
						<summary><b>java</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ src.main.java</b></code>
							<!-- fr Submodule -->
							<details>
								<summary><b>fr</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ src.main.java.fr</b></code>
									<!-- univartois Submodule -->
									<details>
										<summary><b>univartois</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ src.main.java.fr.univartois</b></code>
											<!-- butinfo Submodule -->
											<details>
												<summary><b>butinfo</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ src.main.java.fr.univartois.butinfo</b></code>
													<!-- sae Submodule -->
													<details>
														<summary><b>sae</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ src.main.java.fr.univartois.butinfo.sae</b></code>
															<table style='width: 100%; border-collapse: collapse;'>
															<thead>
																<tr style='background-color: #f8f9fa;'>
																	<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																	<th style='text-align: left; padding: 8px;'>Summary</th>
																</tr>
															</thead>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/HelloApplication.java'>HelloApplication.java</a></b></td>
																	<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																</tr>
															</table>
															<!-- model Submodule -->
															<details>
																<summary><b>model</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ src.main.java.fr.univartois.butinfo.sae.model</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/TypeClient.java'>TypeClient.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/StockGlobal.java'>StockGlobal.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/PaiementSimple.java'>PaiementSimple.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/ClientEtablissementPublic.java'>ClientEtablissementPublic.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/Categorie.java'>Categorie.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/Client.java'>Client.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/Commande.java'>Commande.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/StockEau.java'>StockEau.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/Commune.java'>Commune.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/Adresse.java'>Adresse.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/MethodePaiement.java'>MethodePaiement.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/Paiement.java'>Paiement.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/TraitementPaiement.java'>TraitementPaiement.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/Eau.java'>Eau.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/Entrepot.java'>Entrepot.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/RemisesPossibles.java'>RemisesPossibles.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/LigneDeCommande.java'>LigneDeCommande.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/ClientParticulier.java'>ClientParticulier.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/TypeEtablissement.java'>TypeEtablissement.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/model/ClientEntreprise.java'>ClientEntreprise.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																	</table>
																</blockquote>
															</details>
															<!-- controller Submodule -->
															<details>
																<summary><b>controller</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ src.main.java.fr.univartois.butinfo.sae.controller</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/controller/FormulaireClientController.java'>FormulaireClientController.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/controller/StockEauAjoutModifController.java'>StockEauAjoutModifController.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/controller/CommandeAjoutModifController.java'>CommandeAjoutModifController.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/controller/StockEauController.java'>StockEauController.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/controller/CommandeController.java'>CommandeController.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/controller/ClientController.java'>ClientController.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/java/fr/univartois/butinfo/sae/controller/AccueilController.java'>AccueilController.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<!-- resources Submodule -->
					<details>
						<summary><b>resources</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ src.main.resources</b></code>
							<!-- fr Submodule -->
							<details>
								<summary><b>fr</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ src.main.resources.fr</b></code>
									<!-- univartois Submodule -->
									<details>
										<summary><b>univartois</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ src.main.resources.fr.univartois</b></code>
											<!-- butinfo Submodule -->
											<details>
												<summary><b>butinfo</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ src.main.resources.fr.univartois.butinfo</b></code>
													<!-- sae Submodule -->
													<details>
														<summary><b>sae</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ src.main.resources.fr.univartois.butinfo.sae</b></code>
															<!-- style Submodule -->
															<details>
																<summary><b>style</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ src.main.resources.fr.univartois.butinfo.sae.style</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/resources/fr/univartois/butinfo/sae/style/style.css'>style.css</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																	</table>
																</blockquote>
															</details>
															<!-- view Submodule -->
															<details>
																<summary><b>view</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ src.main.resources.fr.univartois.butinfo.sae.view</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/resources/fr/univartois/butinfo/sae/view/StockEauAjout&ModifView.fxml'>StockEauAjout&ModifView.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/resources/fr/univartois/butinfo/sae/view/StockEauView.fxml'>StockEauView.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/resources/fr/univartois/butinfo/sae/view/Commande-view.fxml'>Commande-view.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/resources/fr/univartois/butinfo/sae/view/FourmulaireClient.fxml'>FourmulaireClient.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/resources/fr/univartois/butinfo/sae/view/CommandeAjoutModif.fxml'>CommandeAjoutModif.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/resources/fr/univartois/butinfo/sae/view/Client-view.fxml'>Client-view.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/main/resources/fr/univartois/butinfo/sae/view/Accueil-view.fxml'>Accueil-view.fxml</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
			<!-- test Submodule -->
			<details>
				<summary><b>test</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ src.test</b></code>
					<!-- java Submodule -->
					<details>
						<summary><b>java</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ src.test.java</b></code>
							<!-- fr Submodule -->
							<details>
								<summary><b>fr</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ src.test.java.fr</b></code>
									<!-- univartois Submodule -->
									<details>
										<summary><b>univartois</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ src.test.java.fr.univartois</b></code>
											<!-- butinfo Submodule -->
											<details>
												<summary><b>butinfo</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ src.test.java.fr.univartois.butinfo</b></code>
													<!-- sae Submodule -->
													<details>
														<summary><b>sae</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ src.test.java.fr.univartois.butinfo.sae</b></code>
															<!-- model Submodule -->
															<details>
																<summary><b>model</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ src.test.java.fr.univartois.butinfo.sae.model</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/test/java/fr/univartois/butinfo/sae/model/CommuneTest.java'>CommuneTest.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/test/java/fr/univartois/butinfo/sae/model/AdresseTest.java'>AdresseTest.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/test/java/fr/univartois/butinfo/sae/model/EauTest.java'>EauTest.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/test/java/fr/univartois/butinfo/sae/model/ClientTest.java'>ClientTest.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/test/java/fr/univartois/butinfo/sae/model/EntrepotTest.java'>EntrepotTest.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/test/java/fr/univartois/butinfo/sae/model/CommandeTest.java'>CommandeTest.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/LTherage/SAE-O-De-France/blob/master/src/test/java/fr/univartois/butinfo/sae/model/StockGlobalTest.java'>StockGlobalTest.java</a></b></td>
																			<td style='padding: 8px;'><code>❯ Gestion du modèle métier de l’application JavaFX</code></td>
																		</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

---

## 🔸 Getting Started

### 🟦 Prerequisites

Ce projet nécessite les outils suivants :

- **Langage:** Java 21
- **Build tool:** Gradle
- **Interface graphique:** JavaFX 21
- **Tests:** JUnit 5, Mockito et AssertJ

### 🟨 Installation

Récupérez le projet puis installez ses dépendances JavaFX et de test :

1. **Cloner le dépôt :**

    ```sh
    ❯ git clone https://github.com/LTherage/SAE-O-De-France
    ```

2. **Accéder au dossier du projet :**

    ```sh
    ❯ cd SAE-O-De-France
    ```

3. **Télécharger les dépendances et compiler :**

    ```sh
    ❯ ./gradlew build
    ```

4. **(Windows uniquement) :**

    ```bat
    gradlew.bat build
    ```

### 🟧 Usage

Lancez l’application à partir du module Gradle :

```sh
./gradlew run
```

Sous Windows :

```bat
gradlew.bat run
```

### 🟥 Testing

Le projet inclut des tests unitaires sur le modèle métier. Pour exécuter la suite de tests :

```sh
./gradlew test
```

Les tests couvrent notamment les classes de gestion des adresses, des communes, des stocks, des commandes et des clients.

---

## ✨ Roadmap

- [X] **`Gestion des clients`** : ajout, modification et affichage des profils client
- [X] **`Gestion des commandes`** : création de commandes et lignes associées
- [X] **`Gestion du stock`** : suivi des bouteilles et des entrepôts
- [X] **`Règles métier`** : remises, fidélité et bouteilles gratuites
- [ ] **`Amélioration de l’interface`** : polish UX et validations avancées
- [ ] **`Persistance`** : sauvegarde des données dans une base ou un fichier externe

---

## ⭐ Contributing

- **💬 [Join the Discussions](https://github.com/LTherage/SAE-O-De-France/discussions)**: Share your insights, provide feedback, or ask questions.
- **🐛 [Report Issues](https://github.com/LTherage/SAE-O-De-France/issues)**: Submit bugs found or log feature requests for the `SAE-O-De-France` project.
- **💡 [Submit Pull Requests](https://github.com/LTherage/SAE-O-De-France/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/LTherage/SAE-O-De-France
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/LTherage/SAE-O-De-France/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=LTherage/SAE-O-De-France">
   </a>
</p>
</details>

---

## 💫 License

Ce dépôt est destiné à un usage pédagogique. Le code est protégé par les droits d’auteur et l’application est fournie sans fichier LICENSE dédié dans ce dépôt. Les sources peuvent être utilisées à des fins d’apprentissage et de démonstration, selon les bonnes pratiques de l’établissement et les consignes du cours.

---

## ✧ Acknowledgments

- Université d’Artois et l’enseignement de développement logiciel
- JavaFX pour l’interface utilisateur
- Gradle pour la gestion du projet
- JUnit, Mockito et AssertJ pour la validation des règles métier

<div align="right">

[![][back-to-top]](#top)

</div>


[back-to-top]: https://img.shields.io/badge/-BACK_TO_TOP-151515?style=flat-square


---
