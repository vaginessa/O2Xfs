/*
 * Copyright (c) 2017, Andreas Fagschlunger. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package at.o2xfs.xfs.idc.v3_20;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.win32.Pointer;
import at.o2xfs.win32.WORD;
import at.o2xfs.xfs.idc.Position;
import at.o2xfs.xfs.idc.v3_10.Status3_10;

public class Status3_20 extends Status3_10 {

	protected final Pointer parkingStationMedia = new Pointer();
	protected final WORD antiFraudModule = new WORD();

	protected Status3_20() {
		add(parkingStationMedia);
		add(antiFraudModule);
	}

	public Status3_20(Pointer p) {
		this();
		assignBuffer(p);
	}

	public Status3_20(Status3_20 copy) {
		this();
		allocate();
		set(copy);
	}

	protected void set(Status3_20 copy) {
		super.set(copy);
		parkingStationMedia.pointTo(new ParkingStationMedias(copy.getParkingStationMedia()));
		antiFraudModule.set(copy.getAntiFraudModule());
	}

	public Position[] getParkingStationMedia() {
		return new ParkingStationMedias(parkingStationMedia).get();
	}

	public int getAntiFraudModule() {
		return antiFraudModule.get();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.appendSuper(super.hashCode())
				.append(getParkingStationMedia())
				.append(getAntiFraudModule())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Status3_20) {
			Status3_20 status3_20 = (Status3_20) obj;
			return new EqualsBuilder()
					.appendSuper(super.equals(obj))
					.append(getParkingStationMedia(), status3_20.getParkingStationMedia())
					.append(getAntiFraudModule(), status3_20.getAntiFraudModule())
					.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
				.append("parkingStationMedia", getParkingStationMedia())
				.append("antiFraudModule", getAntiFraudModule())
				.toString();
	}
}