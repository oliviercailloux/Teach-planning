<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<form action="#">
			<h1>L3 Mention informatique des Oganisations</h1>
			<table>
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
						<td>Remise à niveau en maths</td>
						<td></td>
						<td>12h</td>
						<td>
							<select id="RaN" name="RaN">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Logique</td>
						<td>A3APP01</td>
						<td>30h</td>
						<td>
							<select id="Logique" name="Logique">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Graphes : Modélisation et algorithmes</td>
						<td>A3APP02</td>
						<td>48h</td>
						<td>
							<select name="Graphes">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Base de données relationnelles</td>
						<td>A3APP03</td>
						<td>51h</td>
						<td>
							<select name="BDR">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Probabilités et processus stochastiques</td>
						<td>A3APP14</td>
						<td>36h</td>
						<td>
							<select name="Proba">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Expression écrite - Communication</td>
						<td>A3APP05</td>
						<td>30h</td>
						<td>
							<select name="ExprCom">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Analyse de données</td>
						<td>A3APP06</td>
						<td>42h</td>
						<td>
							<select name="AnaData">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Finance d'entreprise</td>
						<td>A3APP07</td>
						<td>30h</td>
						<td>
							<select name="Finance">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Anglais 5</td>
						<td>A3APP09</td>
						<td>20h</td>
						<td>
							<select name="Ang5">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Ingénierie des systèmes d'information 1</td>
						<td>A3APP08</td>
						<td>30h</td>
						<td>
							<select name="ISI1">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
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
						<td>Ingénierie des systèmes d'information 2</td>
						<td>A3APP10</td>
						<td>30h</td>
						<td>
							<select name="ISI2">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Réseaux : infrastructures</td>
						<td>A3APP11</td>
						<td>36h</td>
						<td>
							<select name="Reseaux">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Comptabilité analytique</td>
						<td>A3APP12</td>
						<td>30h</td>
						<td>
							<select name="Compta">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Sociologie des organisations</td>
						<td>A3APP13</td>
						<td>30h</td>
						<td>
							<select name="Socio">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Programmation linéaire</td>
						<td>A3APP04</td>
						<td>45h</td>
						<td>
							<select name="ProgLin">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Utilisation et programmation UNIX</td>
						<td>A3APP17</td>
						<td>36h</td>
						<td>
							<select name="Unix">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Anglais 6</td>
						<td>A3APP18</td>
						<td>18h</td>
						<td>
							<select name="Ang6">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Java - Objet</td>
						<td>A3APP15</td>
						<td>30h</td>
						<td>
							<select name="JavaObj">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Projet Java</td>
						<td>A3APP16</td>
						<td>20h</td>
						<td>
							<select name="ProjetJava">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
				</table>		
			</table>	
			
			<h1>M1 Mention informatique des Oganisations</h1>
			<table>
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
						<td>Programmation Java avancée</td>
						<td>A4APP06</td>
						<td>36h</td>
						<td>
							<select name="JavaAv">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Intelligence artificielle et raisonnement</td>
						<td>A4APP01</td>
						<td>39h</td>
						<td>
							<select name="IA">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Systèmes et algorithmes répartis</td>
						<td>A4APP02</td>
						<td>36h</td>
						<td>
							<select name="SAR">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Système de gestion de bases de données</td>
						<td>A4APP04</td>
						<td>39h</td>
						<td>
							<select name="SGBD">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Analyse financière</td>
						<td>A4APP08</td>
						<td>30h</td>
						<td>
							<select name="AnaFi">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Système d'information avancés 1</td>
						<td>A4APP07</td>
						<td>30h</td>
						<td>
							<select name="SIA1">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr><td><h3>Bloc communication</h3></td></tr>
					<tr>
						<td>Organisation et communication</td>
						<td>A4APP03</td>
						<td>30h</td>
						<td>
							<select name="OrgCom">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Anglais</td>
						<td>A4APP09</td>
						<td>39h</td>
						<td>
							<select name="Ang">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>LV2</td>
						<td></td>
						<td>30h</td>
						<td>
							<select name="LV2">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
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
						<td>Analyse et fouille de données</td>
						<td>A4APP10</td>
						<td>30h</td>
						<td>
							<select name="FouilleData">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Systèmes d'information avancés 2</td>
						<td>A4APP11</td>
						<td>30h</td>
						<td>
							<select name="SIA2">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Applications réseaux</td>
						<td>A4APP13</td>
						<td>30h</td>
						<td>
							<select name="AppliReseau">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>E - application</td>
						<td>A4APP12</td>
						<td>36h</td>
						<td>
							<select name="Eapp">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Marketing</td>
						<td>A4APP14</td>
						<td>39h</td>
						<td>
							<select name="Market">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr><td><h3>Bloc optionnel</h3></td></tr>
					<tr>
						<td>Marchés financiers</td>
						<td>A4APP19</td>
						<td>24h</td>
						<td>
							<select name="MarcheFi">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>C++</td>
						<td>A4APP15</td>
						<td>24h</td>
						<td>
							<select name="C++">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Décision et analyse multicritère</td>
						<td></td>
						<td>24h</td>
						<td>
							<select name="DeciAnaMulti">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Gestion de production et ordonnancement</td>
						<td></td>
						<td>24h</td>
						<td>
							<select name="GestProdOrdo">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>
					<tr>
						<td>Optimisation combinatoire</td>
						<td></td>
						<td>24h</td>
						<td>
							<select name="OptiComb">
							  <option value="choix0"></option>
							  <option value="choixA">Choix A</option>
							  <option value="choixB">Choix B</option>
							  <option value="choixC">Choix C</option>
							</select>
						</td>
						<td>
							<input type="number" name="nbAnnees" min="0" max="60">
						</td>
					</tr>

				</table>		
			</table>
			<p> Commentaires </p>
			<textarea name="commentaires" rows="10" cols="60"></textarea>
			<br/><br/>
			<input type="submit">	
		</form>
	</body>
</html>