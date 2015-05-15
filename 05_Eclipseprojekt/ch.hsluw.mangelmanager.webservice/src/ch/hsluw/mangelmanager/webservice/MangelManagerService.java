package ch.hsluw.mangelmanager.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ch.hsluw.mangelmanager.model.Adresse;
import ch.hsluw.mangelmanager.model.Arbeitstyp;
import ch.hsluw.mangelmanager.model.Bauherr;
import ch.hsluw.mangelmanager.model.GuMitarbeiter;
import ch.hsluw.mangelmanager.model.Login;
import ch.hsluw.mangelmanager.model.Mangel;
import ch.hsluw.mangelmanager.model.Mangelstatus;
import ch.hsluw.mangelmanager.model.Meldung;
import ch.hsluw.mangelmanager.model.Meldungstyp;
import ch.hsluw.mangelmanager.model.Objekttyp;
import ch.hsluw.mangelmanager.model.Person;
import ch.hsluw.mangelmanager.model.Plz;
import ch.hsluw.mangelmanager.model.Projekt;
import ch.hsluw.mangelmanager.model.ProjektGuMitarbeiter;
import ch.hsluw.mangelmanager.model.ProjektSuMitarbeiter;
import ch.hsluw.mangelmanager.model.SuMitarbeiter;
import ch.hsluw.mangelmanager.model.Subunternehmen;

@WebService
public interface MangelManagerService {
	
	@WebMethod
	public abstract List<Projekt> getAllProjekt();
	@WebMethod
	public abstract List<Subunternehmen> getAllSubunternehmen();
	@WebMethod
	public abstract String getProjektproSubunternehmen(int subunternehmen);
	@WebMethod
	public abstract List<Mangel> getAllMangel();
	@WebMethod
	public abstract List<Meldung> getAllMeldung();
	@WebMethod
	public abstract Projekt getProjektById(int projektId);
	@WebMethod
	public abstract Subunternehmen getSubunternehmenById(int subunternehmenId);
	@WebMethod
	public abstract Meldung getMeldungById(int meldungId);
	@WebMethod
	public abstract List<Person> getAllPerson();
	@WebMethod
	public abstract void updateSubunternehmen(Subunternehmen subunternehmen);
	@WebMethod
	public abstract List<Projekt> getProjektByBezeichnung(String bezeichnung);
	@WebMethod
	public abstract List<Plz> getAllPlz();
	@WebMethod
	public abstract List<Projekt> getProjektByBauherr(String bauherr);
	@WebMethod
	public abstract List<Projekt> getProjektByPlz(String plz);
	@WebMethod
	public abstract List<Projekt> getProjektByOrt(String ort);
	@WebMethod
	public abstract Plz getPlzById(int plzId);
	@WebMethod
	public abstract List<Projekt> getProjektByObjekttyp(String objekttyp);
	@WebMethod
	public abstract List<Projekt> getProjektByArbeitstyp(String arbeitstyp);
	@WebMethod
	public abstract List<Projekt> getProjektByProjektstatus(String projektstatus);
	@WebMethod
	public abstract void addAdresse(Adresse adresse);
	@WebMethod
	public abstract void addSubunternehmen(Subunternehmen addSubunternehmen);
	@WebMethod
	public abstract List<Projekt> getAllSubunternehmenProjekt(
			Subunternehmen subunternehmen);
	@WebMethod
	public abstract List<SuMitarbeiter> getAllSubunternehmenMitarbeiter(
			Subunternehmen subunternehmen);
	@WebMethod
	public abstract List<Objekttyp> getAllObjekttyp();
	@WebMethod
	public abstract List<Arbeitstyp> getAllArbeitstyp();
	@WebMethod
	public abstract List<Mangel> getAllMangelProjekt(Projekt projekt);
	@WebMethod
	public abstract Mangel getMangelById(Integer mangelId);
	@WebMethod
	public abstract void updateMangel(Mangel mangel);
	@WebMethod
	public abstract List<Mangelstatus> getAllMangelStatus();
	@WebMethod
	public abstract void addMangel(Mangel mangel);
	@WebMethod
	public abstract List<Meldungstyp> getAllMeldungstyp();
	@WebMethod
	public abstract void addMeldung(Meldung meldung);
	@WebMethod
	public abstract List<Meldung> getAllMeldungByMangel(Mangel mangel);
	@WebMethod
	public abstract List<Subunternehmen> getUnternehmenByProjekt(
			Projekt projekt2);
	@WebMethod
	public abstract List<ProjektGuMitarbeiter> getBauleiterByProjekt(
			Projekt projekt2);
	@WebMethod
	public abstract Login getLoginByName(String name);
	@WebMethod
	public abstract Login getLoginById(Integer loginId);
	@WebMethod
	public abstract void updateProjekt(Projekt projekt2);
	@WebMethod
	public abstract void addSuMitarbeiterByProjekt(ProjektSuMitarbeiter psum);
	@WebMethod
	public abstract List<Bauherr> getAllBauherr();
	@WebMethod
	public abstract void addProjekt(Projekt projekt2);
	@WebMethod
	public abstract List<GuMitarbeiter> getAllGuMitarbeiter();
	@WebMethod
	public abstract void addGuMitarbeiterByProjekt(
			ProjektGuMitarbeiter projektGuMitarbeiter);
}