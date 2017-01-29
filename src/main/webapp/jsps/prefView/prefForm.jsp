<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add preference teaching</title>
		<style>
			table {
				border-collapse: collapse;
			}
			#sem5 {
				background-color: #A0D3EF;
			}
			#sem6 {
				background-color: #A0D3EF;
			}
			#sem7 {
				background-color: #A0D3EF;
			}
			#sem8 {
				background-color: #A0D3EF;
			}
		</style>
	</head>
	<body>
		<form action="../../addPref" method="post">
			<h1>L3 Mention informatique des Oganisations</h1>
			<h2>Semestre 5</h2>
			<table>
					<tr id='sem5'>
						<th>Matiere</th>
						<th>Code apogée</th>
						<th>Nb heures Cours-TD</th>
						<th>Choix</th>
						<th>Nb années d'enseignement de la matière</th>
					</tr>
					<tr>
						<td>Remise à niveau en maths<input type="hidden" name="M1" value="Remise à niveau en maths"></td>
						<td></td>
						<td>12h<input type="hidden" name="H1" value="12"></td>
						<td>
							<select id="RaN" name="choix1">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA1" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Logique<input type="hidden" name="M2" value="Logique"></td>
						<td>A3APP01</td>
						<td>30h<input type="hidden" name="H2" value="30"></td>
						<td>
							<select id="Logique" name="choix2">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA2" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Graphes : Modélisation et algorithmes<input type="hidden" name="M3" value="Graphes : Modélisation et algorithmes"></td>
						<td>A3APP02</td>
						<td>48h<input type="hidden" name="H3" value="48"></td>
						<td>
							<select name="choix3">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nb3" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Base de données relationnelles<input type="hidden" name="M4" value="Base de données relationnelles"></td>
						<td>A3APP03</td>
						<td>51h<input type="hidden" name="H4" value="51"></td>
						<td>
							<select name="choix4">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA4" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Probabilités et processus stochastiques<input type="hidden" name="M5" value="Probabilités et processus stochastiques"></td>
						<td>A3APP14</td>
						<td>36h<input type="hidden" name="H5" value="36"></td>
						<td>
							<select name="choix5">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA5" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Expression écrite - Communication<input type="hidden" name="M6" value="Expression écrite - Communication"></td>
						<td>A3APP05</td>
						<td>30h<input type="hidden" name="H6" value="30"></td>
						<td>
							<select name="choix6">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA6" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Analyse de données<input type="hidden" name="M7" value="Analyse de données"></td>
						<td>A3APP06</td>
						<td>42h<input type="hidden" name="H7" value="42"></td>
						<td>
							<select name="choix7">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA7" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Finance d'entreprise<input type="hidden" name="M8" value="Finance d'entreprise"></td>
						<td>A3APP07</td>
						<td>30h<input type="hidden" name="H8" value="30"></td>
						<td>
							<select name="choix8">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA8" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Anglais 5<input type="hidden" name="M9" value="Anglais 5"></td>
						<td>A3APP09</td>
						<td>20h<input type="hidden" name="H9" value="20"></td>
						<td>
							<select name="choix9">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA9" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Ingénierie des systèmes d'information 1<input type="hidden" name="M10" value="Ingénierie des systèmes d'information 1"></td>
						<td>A3APP08</td>
						<td>30h<input type="hidden" name="H10" value="30"></td>
						<td>
							<select name="choix10">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA10" min="0" max="60">
						</td>
					</tr>
				</table>
				
				<h2>Semestre 6</h2>
				<table>
					<tr id='sem6'>
						<th>Matiere</th>
						<th>Code apogée</th>
						<th>Nb heures Cours-TD</th>
						<th>Choix</th>
						<th>Nb années d'enseignement de la matière</th>
					</tr>
					<tr>
						<td>Ingénierie des systèmes d'information 2<input type="hidden" name="M11" value="Ingénierie des systèmes d'information 2"></td>
						<td>A3APP10</td>
						<td>30h<input type="hidden" name="H11" value="30"></td>
						<td>
							<select name="choix11">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA11" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Réseaux : infrastructures<input type="hidden" name="M12" value="Réseaux : infrastructures"></td>
						<td>A3APP11</td>
						<td>36h<input type="hidden" name="H12" value="36"></td>
						<td>
							<select name="choix12">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA12" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Comptabilité analytique<input type="hidden" name="M13" value="Comptabilité analytique"></td>
						<td>A3APP12</td>
						<td>30h<input type="hidden" name="H13" value="30"></td>
						<td>
							<select name="choix13">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA13" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Sociologie des organisations<input type="hidden" name="M14" value="Sociologie des organisations"></td>
						<td>A3APP13</td>
						<td>30h<input type="hidden" name="H14" value="30"></td>
						<td>
							<select name="choix14">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA14" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Programmation linéaire<input type="hidden" name="M15" value="Programmation linéaire"></td>
						<td>A3APP04</td>
						<td>45h<input type="hidden" name="H15" value="45"></td>
						<td>
							<select name="choix15">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA15" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Utilisation et programmation UNIX<input type="hidden" name="M16" value="Utilisation et programmation UNIX"></td>
						<td>A3APP17</td>
						<td>36h<input type="hidden" name="H16" value="36"></td>
						<td>
							<select name="choix16">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA16" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Anglais 6<input type="hidden" name="M17" value="nglais 6"></td>
						<td>A3APP18</td>
						<td>18h<input type="hidden" name="H17" value="18"></td>
						<td>
							<select name="choix17">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA17" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Java - Objet<input type="hidden" name="M18" value="Java - Objet"></td>
						<td>A3APP15</td>
						<td>30h<input type="hidden" name="H18" value="30"></td>
						<td>
							<select name="choix18">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA18" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Projet Java<input type="hidden" name="M19" value="Projet Java"></td>
						<td>A3APP16</td>
						<td>20h<input type="hidden" name="H19" value="20"></td>
						<td>
							<select name="choix19">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA19" min="0" max="60">
						</td>
					</tr>
				</table>		
			
			<h1>M1 Mention informatique des Oganisations</h1>
				<h2>Semestre 7</h2>
				<table>
					<tr id='sem7'>
						<th>Matiere</th>
						<th>Code apogée</th>
						<th>Nb heures Cours-TD</th>
						<th>Choix</th>
						<th>Nb années d'enseignement de la matière</th>
					</tr>
					<tr><td><h3>Bloc fondamental</h3></td></tr>
					<tr>
						<td>Programmation Java avancée<input type="hidden" name="M20" value="Programmation Java avancée"></td>
						<td>A4APP06</td>
						<td>36h<input type="hidden" name="H20" value="36"></td>
						<td>
							<select name="choix20">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA20" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Intelligence artificielle et raisonnement<input type="hidden" name="M21" value="Intelligence artificielle et raisonnement"></td>
						<td>A4APP01</td>
						<td>39h<input type="hidden" name="H21" value="39"></td>
						<td>
							<select name="choix21">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA21" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Systèmes et algorithmes répartis<input type="hidden" name="M22" value="Systèmes et algorithmes répartis"></td>
						<td>A4APP02</td>
						<td>36h<input type="hidden" name="H22" value="36"></td>
						<td>
							<select name="choix22">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA22" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Système de gestion de bases de données<input type="hidden" name="M23" value="Système de gestion de bases de données"></td>
						<td>A4APP04</td>
						<td>39h<input type="hidden" name="H23" value="39"></td>
						<td>
							<select name="choix23">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA23" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Analyse financière<input type="hidden" name="M24" value="Analyse financière"></td>
						<td>A4APP08</td>
						<td>30h<input type="hidden" name="H24" value="30"></td>
						<td>
							<select name="choix24">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA24" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Système d'information avancés 1<input type="hidden" name="M25" value="Système d'information avancés 1"></td>
						<td>A4APP07</td>
						<td>30h<input type="hidden" name="H25" value="30"></td>
						<td>
							<select name="choix25">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA25" min="0" max="60">
						</td>
					</tr>
					<tr><td><h3>Bloc communication</h3></td></tr>
					<tr>
						<td>Organisation et communication<input type="hidden" name="M26" value="Organisation et communication"></td>
						<td>A4APP03</td>
						<td>30h<input type="hidden" name="H26" value="30"></td>
						<td>
							<select name="choix26">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA26" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Anglais<input type="hidden" name="M27" value="Anglais"></td>
						<td>A4APP09</td>
						<td>39h<input type="hidden" name="H27" value="39"></td>
						<td>
							<select name="choix27">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA27" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>LV2<input type="hidden" name="M28" value="LV2"></td>
						<td></td>
						<td>30h<input type="hidden" name="H28" value="30"></td>
						<td>
							<select name="choix28">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA28" min="0" max="60">
						</td>
					</tr>
				</table>
				
				<h2>Semestre 8</h2>
				<table>
					<tr id='sem8'>
						<th>Matiere</th>
						<th>Code apogée</th>
						<th>Nb heures Cours-TD</th>
						<th>Choix</th>
						<th>Nb années d'enseignement de la matière</th>
					</tr>
					<tr><td><h3>Bloc d'application</h3></td></tr>
					<tr>
						<td>Analyse et fouille de données<input type="hidden" name="M29" value="Analyse et fouille de données"></td>
						<td>A4APP10</td>
						<td>30h<input type="hidden" name="H29" value="30"></td>
						<td>
							<select name="choix29">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA29" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Systèmes d'information avancés 2<input type="hidden" name="M30" value="Systèmes d'information avancés 2"></td>
						<td>A4APP11</td>
						<td>30h<input type="hidden" name="H30" value="30"></td>
						<td>
							<select name="choix30">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA30" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Applications réseaux<input type="hidden" name="M31" value="Applications réseaux"></td>
						<td>A4APP13</td>
						<td>30h<input type="hidden" name="H31" value="30"></td>
						<td>
							<select name="choix31">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA31" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>E - application<input type="hidden" name="M32" value="E-application"></td>
						<td>A4APP12</td>
						<td>36h<input type="hidden" name="H32" value="36"></td>
						<td>
							<select name="choix32">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA32" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Marketing<input type="hidden" name="M33" value="Marketing"></td>
						<td>A4APP14</td>
						<td>39h<input type="hidden" name="H33" value="39"></td>
						<td>
							<select name="choix33">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA33" min="0" max="60">
						</td>
					</tr>
					<tr><td><h3>Bloc optionnel</h3></td></tr>
					<tr>
						<td>Marchés financiers<input type="hidden" name="M34" value="Marchés financiers"></td>
						<td>A4APP19</td>
						<td>24h<input type="hidden" name="H34" value="24"></td>
						<td>
							<select name="choix34">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA34" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>C++<input type="hidden" name="M35" value="C++"></td>
						<td>A4APP15</td>
						<td>24h<input type="hidden" name="H35" value="24"></td>
						<td>
							<select name="choix35">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA35" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Décision et analyse multicritère<input type="hidden" name="M36" value="Décision et analyse multicritère"></td>
						<td></td>
						<td>24h<input type="hidden" name="H36" value="24"></td>
						<td>
							<select name="choix36">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nb36" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Gestion de production et ordonnancement<input type="hidden" name="M37" value="Gestion de production et ordonnancement"></td>
						<td></td>
						<td>24h<input type="hidden" name="H37" value="24"></td>
						<td>
							<select name="choix37">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA37" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Optimisation combinatoire<input type="hidden" name="M38" value="Optimisation combinatoire"></td>
						<td></td>
						<td>24h<input type="hidden" name="H38" value="24"></td>
						<td>
							<select name="choix38">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbA38" min="0" max="60">
						</td>
					</tr>
				</table>	
			<p> Commentaires </p>
			<textarea name="commentaires" rows="10" cols="60"></textarea>
			<br/><br/>
			<input type="submit">	
		</form>
	</body>
</html>