<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>



<div class="row">
	<div class="col-3">
		<div class="list-group" id="list-tab" role="tablist">
			<a class="list-group-item list-group-item-action active"
				id="list-home-list" data-toggle="list" href="#etape1" role="tab"
				aria-controls="etape1">Marseille</a>
			<a class="list-group-item list-group-item-action"
				id="list-profile-list" data-toggle="list" href="#etape2" role="tab"
				aria-controls="etape2">Paris</a>
			<a class="list-group-item list-group-item-action"
				id="list-messages-list" data-toggle="list" href="#etape3" role="tab"
				aria-controls="etape3">Londres</a>
			<a class="list-group-item list-group-item-action"
				id="list-settings-list" data-toggle="list" href="#etape4" role="tab"
				aria-controls="etape4">Genève</a>
		</div>
		<div class="btn-group mt-2 text-center" role="group"
			aria-label="First group">
			<button type="button" class="btn btn-primary">+</button>
			<button type="button" class="btn btn-primary">^</button>
			<button type="button" class="btn btn-primary">-</button>
		</div>
	</div>
	<div class="col-9">
		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane fade show active" id="etape1" role="tabpanel"
				aria-labelledby="list-home-list">Marseille, ville portuaire du
				sud de la France, est un carrefour du commerce et de l'immigration
				depuis sa fondation par les Grecs vers 600 av. J.-C. En son cœur se
				trouve le Vieux-Port où les pêcheurs vendent leurs prises sur le
				quai bordé de bateaux. La basilique Notre-Dame-de-la-Garde est une
				église romane d'inspiration byzantine. Les constructions modernes
				incluent notamment la Cité Radieuse, unité d'habitations conçue par
				Le Corbusier et la Tour CMA CGM de Zaha Hadid.
				<p>Superficie : 240,6 km²</p>
				<p>Météo : 8 °C, vent E à 13 km/h, 74 % d'humidité</p>
				<p>Arrondissement : Arrondissement de Marseille</p>
				<p>Maire : Jean-Claude Gaudin</p>
				<p>Population : 1,059 million (2014) INSEE</p></div>

			<div class="tab-pane fade" id="etape2" role="tabpanel"
				aria-labelledby="list-profile-list">Paris, capitale de la
				France, est une grande ville européenne et un centre mondial de
				l'art, de la mode, de la gastronomie et de la culture. Son paysage
				urbain du XIXe siècle est traversé par de larges boulevards et la
				Seine. Outre les monuments comme la tour Eiffel et la cathédrale
				gothique Notre-Dame du XIIe siècle, la ville est réputée pour ses
				cafés et ses boutiques de luxe bordant la rue du
				Faubourg-Saint-Honoré.</div>

			<div class="tab-pane fade" id="etape3" role="tabpanel"
				aria-labelledby="list-messages-list">Londres, la capitale de
				l'Angleterre et du Royaume-Uni, est une ville moderne dont
				l'histoire remonte à l'époque romaine. En son centre se dressent
				l'imposant Parlement, l'emblématique Big Ben et l'abbaye de
				Westminster, lieu de couronnement des monarques britanniques. De
				l'autre côté de la Tamise, le London Eye, la grande roue, offre une
				vue panoramique sur le South Bank Center, et toute la ville.</div>
				
			<div class="tab-pane fade" id="etape4" role="tabpanel"
				aria-labelledby="list-settings-list">Genève est une ville
				suisse située à la pointe sud du lac Léman. Entourée par les
				montagnes du Jura et des Alpes, la ville offre des vues
				exceptionnelles sur le majestueux Mont-Blanc. Siège de l'Office des
				Nations Unies et de la Croix-Rouge, elle est un centre mondial de la
				diplomatie et du secteur bancaire. L'influence française est
				largement répandue, de la langue à la gastronomie en passant par le
				quartier bohème de Carouge.</div>
		</div>
	</div>
</div>
