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

package at.o2xfs.xfs.v3_00.idc;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.win32.LPSTR;
import at.o2xfs.win32.Pointer;
import at.o2xfs.win32.Struct;
import at.o2xfs.xfs.idc.DataStatus;
import at.o2xfs.xfs.win32.XfsWordBitmask;

public class TrackEvent3 extends Struct {

	protected final XfsWordBitmask<DataStatus> status = new XfsWordBitmask<>(DataStatus.class);
	protected final LPSTR track = new LPSTR();
	protected final LPSTR data = new LPSTR();

	protected TrackEvent3() {
		add(status);
		add(track);
		add(data);
	}

	public TrackEvent3(Pointer p) {
		this();
		assignBuffer(p);
	}

	public TrackEvent3(TrackEvent3 copy) {
		this();
		allocate();
		set(copy);
	}

	protected void set(TrackEvent3 copy) {
		status.set(copy.getStatus());
		track.set(copy.getTrack());
		data.set(copy.getData());
	}

	public Set<DataStatus> getStatus() {
		return status.get();
	}

	public String getTrack() {
		return track.get();
	}

	public String getData() {
		return data.get();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getStatus()).append(getTrack()).append(getData()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TrackEvent3) {
			TrackEvent3 trackEvent3 = (TrackEvent3) obj;
			return new EqualsBuilder()
					.append(getStatus(), trackEvent3.getStatus())
					.append(getTrack(), trackEvent3.getTrack())
					.append(getData(), trackEvent3.getData())
					.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("status", getStatus())
				.append("track", getTrack())
				.append("data", getData())
				.toString();
	}
}
