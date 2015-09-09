package de.akquinet.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.akquinet.address.model.Address;
import de.akquinet.address.model.Anreden;

@Path("address")
public class AdressService {

	private static Map<Long, Address> adressMap = new HashMap<Long, Address>();

	static {

		adressMap.put(1l, new Address(1l, Anreden.Herr, "Günti", "Wand",
				"guenter.wand@test.de"));
		adressMap.put(2l, new Address(2l, Anreden.Frau, "Cecelia", "Bartoli",
				"cb@test.de"));
		adressMap.put(3l, new Address(3l, Anreden.Frau, "Amy", "Winehouse",
				"awinehouse@test.de"));
		adressMap.put(4l, new Address(4l, Anreden.Herr, "Mischa", "Maisky",
				"mm@test.de"));
		adressMap.put(5l, new Address(5l, Anreden.Herr, "Ludwig", "van Beethoven",
				"vonBeethoven@test.de"));

	}

	@GET
	@Path("element/{addressId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Address getAddress(@PathParam("addressId") Long id) {
		return adressMap.get(id);
	}

	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Address> getAddressListe() {
		List<Address> addressListe = new ArrayList<Address>();
		addressListe.addAll(adressMap.values());
		return (ArrayList<Address>) addressListe;
	}

	@POST
	@Path("new")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void speichereAddresse(Address address) {
		adressMap.put(address.getId(), address);
	}

	@PUT
	@Path("update/{addressId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAddresse(@PathParam("addressId") long addressId,
			Address address) {
		if (address != null) {
			adressMap.put(addressId, address);
		}
	}

	@DELETE
	@Path("delete/{addressId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteAddresse(@PathParam("addressId") long addressId) {
		adressMap.remove(addressId);
	}

	
}
